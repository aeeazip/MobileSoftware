package ddwucom.mobile.example.test11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class SubActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.subactivity);
    }

    public void onClick(View v){
        EditText foodName = findViewById (R.id.et_food_name);
        EditText nation = findViewById (R.id.et_nation);

        switch(v.getId()){
            case R.id.add:
                Food food = new Food(foodName.getText().toString(), nation.getText().toString());

                Intent intent = new Intent();
                intent.putExtra("newFood", (Serializable)food);
                setResult(RESULT_OK, intent);
                break;
            case R.id.cancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}
