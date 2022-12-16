package ddwucom.mobile.example.test13;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    FoodDBHelper helper;
    EditText id;
    EditText foodName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        helper = new FoodDBHelper(this);
        id = findViewById (R.id.etUpdateId);
        foodName = findViewById (R.id.etUpdateFood);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnUpdateFood:
                SQLiteDatabase db = helper.getWritableDatabase();

                ContentValues row = new ContentValues();
                row.put("food", foodName.getText().toString());

                String whereClause = "_id = ?";
                String[] args = new String[]{id.getText().toString()};

                db.update(FoodDBHelper.TABLE_NAME, row, whereClause, args);
                break;
        }
        helper.close();
        finish();
    }
}
