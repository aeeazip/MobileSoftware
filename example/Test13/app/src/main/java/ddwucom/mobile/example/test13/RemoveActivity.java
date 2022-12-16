package ddwucom.mobile.example.test13;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RemoveActivity extends AppCompatActivity {
    FoodDBHelper helper;
    EditText food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        helper = new FoodDBHelper(this);
        food = findViewById (R.id.etRemoveFood);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnRemoveFood:
                SQLiteDatabase db = helper.getWritableDatabase();

                String whereClause = "food=?";
                String str = food.getText().toString();
                String[] args = new String[]{str};

                db.delete(FoodDBHelper.TABLE_NAME, whereClause, args);
                break;
        }
        helper.close();
        finish();
    }
}
