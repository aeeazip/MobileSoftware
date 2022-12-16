package ddwucom.mobile.week04.calculatorsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    static int num1 = 0;
    static int num2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        EditText text = (EditText)findViewById(R.id.etDisplay);
        String num = null;

        switch(v.getId()){
            case R.id.btn_1:
                num = text.getText().toString() + "1";
                text.setText(num);
                break;
            case R.id.btn_2:
                num = text.getText().toString() + "2";
                text.setText(num);
                break;
            case R.id.btn_plus:
                num1 = Integer.parseInt(text.getText().toString());
                text.setText("");
                break;
            case R.id.btn_equal:
                num2 = Integer.parseInt(text.getText().toString());
                text.setText(Integer.toString(num1+num2));
                break;
        }
    }
}