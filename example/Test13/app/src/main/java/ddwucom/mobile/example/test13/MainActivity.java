package ddwucom.mobile.example.test13;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tvDisplay;
    FoodDBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);
        helper = new FoodDBHelper(this);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnSelect:
                SQLiteDatabase db = helper.getReadableDatabase();
                String[] columns = null; //new String[] { FoodDBHelper.COL_ID, FoodDBHelper.COL_FOOD, FoodDBHelper.COL_NATION};
                String selection = null;
                String[] selectArgs = null;

                Cursor cursor =
                        db.query(FoodDBHelper.TABLE_NAME, columns, selection, selectArgs, null, null, null, null);


                ArrayList<Food> foodList = new ArrayList<Food>();

                while(cursor.moveToNext()){
                    long _id = cursor.getLong(0);//cursor.getLong(0);
                    String foodName = cursor.getString(1);
                    String nation = cursor.getString(2);

                    Food food = new Food(_id, foodName, nation);
                    foodList.add(food);
                }

                cursor.close();
                helper.close();

                String result = "";
                for (Food newFood : foodList){
                    result += newFood.toString() + "\n";
                }

                tvDisplay.setText(result);

                break;
            case R.id.btnAdd:
                Intent intent = new Intent(this, AddActivity.class);
                startActivity(intent);
                break;
            case R.id.btnUpdate:
                Intent intent1 = new Intent(this, UpdateActivity.class);
                startActivity(intent1);
                break;
            case R.id.btnRemove:
                Intent intent2 = new Intent(this, RemoveActivity.class);
                startActivity(intent2);
                break;
        }
        helper.close();
    }
}