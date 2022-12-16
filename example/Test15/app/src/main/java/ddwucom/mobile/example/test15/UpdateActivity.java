package ddwucom.mobile.example.test15;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {
    Food food;
    FoodDBHelper helper;
    FoodDBManager manager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_update);

        helper = new FoodDBHelper (this);
        manager = new FoodDBManager (this);
    }

    public void onClick(View v){
        switch(v.getId()) {
            case R.id.btn_update:
                EditText foodName = findViewById (R.id.et_food_name);
                EditText nation = findViewById (R.id.et_nation);

                food.setFood (foodName.getText ().toString ());
                food.setNation (nation.getText ().toString ());

                if (manager.modifyFood (food)) {
                    Intent intent = new Intent ();
                    intent.putExtra ("foodName", foodName.getText ().toString ());
                    setResult (RESULT_OK, intent);
                } else
                    setResult (RESULT_CANCELED);
                break;
            case R.id.btn_cancel:
                setResult (RESULT_CANCELED);
                break;
        }
        finish();
    }
}
