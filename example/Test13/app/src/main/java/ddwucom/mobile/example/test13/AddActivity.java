package ddwucom.mobile.example.test13;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    FoodDBHelper helper;
    EditText foodName;
    EditText nation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        helper = new FoodDBHelper(this);
        foodName = findViewById (R.id.etAddFood);
        nation = findViewById (R.id.etAddNation);
    }


    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnAddFood:
                SQLiteDatabase db = helper.getWritableDatabase();

                ContentValues row = new ContentValues();
                row.put("food", foodName.getText().toString());
                row.put("nation", nation.getText().toString());

                db.insert(FoodDBHelper.TABLE_NAME, null, row);
                break;
        }
        helper.close();
        finish();
    }


}
