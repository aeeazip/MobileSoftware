package ddwucom.mobile.test14.exam02;

import static android.content.DialogInterface.*;
import static android.widget.Adapter.*;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";
    final int REQ_CODE = 100;
    final int UPDATE_CODE = 200;

    ListView listView;
    ArrayAdapter adapter;
    ArrayList<Food> foodList = null;
    FoodDBHelper dbHelper;
    FoodDBManager foodDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        foodList = new ArrayList<Food>();
        dbHelper = new FoodDBHelper(this);
        adapter = new ArrayAdapter<Food>(this, android.R.layout.simple_list_item_1, foodList);
        listView.setAdapter(adapter);
        foodDBManager = new FoodDBManager(this);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener (){

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
               final int pos = position;

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.dialog_title)
                        .setMessage(R.string.dialog_message)
                        .setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // deleteRecord(pos);
                                boolean result = foodDBManager.removeFood(foodList.get(pos).get_id());

                                if(result) {
                                    Toast.makeText (MainActivity.this, "삭제완료", Toast.LENGTH_SHORT).show ();
                                    foodList.clear();
                                    foodList.addAll(foodDBManager.getAllFood());
                                    adapter.notifyDataSetChanged();
                                }
                                else
                                    Toast.makeText(MainActivity.this, "삭제실패", Toast.LENGTH_SHORT).show();

                            }
                        })
                        .setNegativeButton(R.string.dialog_cancel, null)
                        .setCancelable(false)
                        .show();


                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Food food = foodList.get(position);
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                // food 객체가 Serializable interface를 implements하고 있기 때문에 가능함.
                intent.putExtra("food", food);
                startActivityForResult(intent, UPDATE_CODE);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume ();
        foodList.clear();
        // readAllFoods();
        foodList.addAll(foodDBManager.getAllFood());
        adapter.notifyDataSetChanged();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, AddActivity.class);
                startActivityForResult(intent, REQ_CODE);
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE) {  // AddActivity 호출 후 결과 확인
            switch (resultCode) {
                case RESULT_OK:
                    String food = data.getStringExtra("food");
                    Toast.makeText(this, food + " 추가 완료", Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "음식 추가 취소", Toast.LENGTH_SHORT).show();
                    break;
            }
        } else if (requestCode == UPDATE_CODE) {    // UpdateActivity 호출 후 결과 확인
            switch (resultCode) {
                case RESULT_OK:
                    Toast.makeText(this, "음식 수정 완료", Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "음식 수정 취소", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    /*
    private void deleteRecord(int pos){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String whereClause = FoodDBHelper.COL_ID + "=?";

        // 해당 pos의 Food 객체를 꺼내고, Food 객체에서 id를 추출
        // ListView의 pos번째 위치에 해당하는 Food 객체에서 id 추출하여 문자열로 변환
        String[] whereArgs = new String[]{String.valueOf(foodList.get(pos).get_id())};

        int result = sqLiteDatabase.delete(FoodDBHelper.TABLE_NAME, whereClause, whereArgs);

        if(result > 0) {
            Toast.makeText (this, "삭제완료", Toast.LENGTH_SHORT).show ();
            foodList.clear();
            foodList.addAll(foodDBManager.getAllFood());
            adapter.notifyDataSetChanged();
        }
        else
            Toast.makeText(this, "삭제실패", Toast.LENGTH_SHORT).show();

        dbHelper.close();
    }
    */

    /*
    private void readAllFoods(){
        foodList.clear();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + FoodDBHelper.TABLE_NAME, null);

        while(cursor.moveToNext()) {
            long id = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_ID));
            String food = cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_FOOD));
            String nation = cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_NATION));
            foodList.add ( new Food (id, food, nation) );
        }

        cursor.close();
        dbHelper.close();
    }*/


}
