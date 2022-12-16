package ddwucom.mobile.week13.labhw12_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    EditText etFood;
    EditText etNation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        etFood = findViewById(R.id.et_food_name);
        etNation = findViewById(R.id.et_nation);
    }


    public void onClick(View v) {
        // 버튼의 종류에 따라 결과 설정 후 finish()
        switch(v.getId()){
            case R.id.btn_add:
                String foodName = etFood.getText().toString();
                String nation = etNation.getText().toString();
                Food food = new Food(foodName, nation);

                Intent intent = new Intent();
                intent.putExtra("newFood", food);
                setResult(RESULT_OK, intent);
                break;
            case R.id.btn_cancel:
                setResult(RESULT_CANCELED);
                break;
        }
         finish();
    }
}


