package ddwucom.mobile.week13.labhw12_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.button1:
                EditText editText = findViewById(R.id.editText1);

                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("input", editText.getText().toString());
                startActivity(intent);
                break;
        }
    }
}