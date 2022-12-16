package ddwucom.mobile.test14.exam02;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    Food food;
    EditText etFood;
    EditText etNation;
    FoodDBManager foodDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        food = (Food) getIntent().getSerializableExtra("food");

        etFood = findViewById(R.id.et_food_name);
        etNation = findViewById (R.id.et_nation);

        etFood.setText(food.getFood());
        etNation.setText(food.getNation());

        foodDBManager = new FoodDBManager(this);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_update:
                // 수정하려고 작성한 음식과 나라값 가져오기
                String foodName = etFood.getText().toString();
                String nation = etNation.getText().toString();

                food.setFood(foodName);
                food.setNation(nation);

                if(foodDBManager.modifyFood (food)) {
                    Intent resultIntent = new Intent ();
                    resultIntent.putExtra ("foodName", foodName);
                    setResult (RESULT_OK, resultIntent);
                } else{
                    setResult(RESULT_CANCELED);
                }
                break;
            case R.id.btn_cancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}
