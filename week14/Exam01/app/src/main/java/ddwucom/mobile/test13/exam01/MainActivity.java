package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvDisplay;
    FoodDBHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);

        myDbHelper = new FoodDBHelper(this);
    }


    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnSelect:
                SQLiteDatabase db = myDbHelper.getReadableDatabase();
                String[] columns = null; //new String[] { FoodDBHelper.COL_ID, FoodDBHelper.COL_FOOD, FoodDBHelper.COL_NATION};
                String selection = null;
                String[] selectArgs = null;

                Cursor cursor =
                        db.query(FoodDBHelper.TABLE_NAME, columns, selection, selectArgs, null, null, null, null);


                ArrayList<Food> foodList = new ArrayList<Food>();

                while(cursor.moveToNext()){
                    long _id = cursor.getLong(cursor.getColumnIndex(FoodDBHelper.COL_ID));//cursor.getLong(0);
                    String foodName = cursor.getString(1);
                    String nation = cursor.getString(2);

                    Food food = new Food(_id, foodName, nation);
                    foodList.add(food);
                }

                cursor.close();
                myDbHelper.close();

                String result = "";
                for (Food newFood : foodList){
                    result += newFood.toString() + "\n";
                }

                tvDisplay.setText(result);

                break;
            case R.id.btnAdd:
                db = myDbHelper.getWritableDatabase();
                ContentValues row  = new ContentValues();
                row.put(FoodDBHelper.COL_FOOD, "갈비탕");
                row.put(FoodDBHelper.COL_NATION, "한국");
                db.insert(FoodDBHelper.TABLE_NAME, null, row);
                myDbHelper.close();
                break;
            case R.id.btnUpdate:

                break;
            case R.id.btnRemove:

                break;
        }

        myDbHelper.close();
    }

}
