package ddwucom.mobile.week03.HW2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        EditText editText = findViewById(R.id.editText);
        String str = editText.getText().toString();

        switch(v.getId()){
            case R.id.btnOne:
                editText.setText(str+"1");
                break;
            case R.id.btnTwo:
                editText.setText(str+"2");
                break;
            case R.id.btnThree:
                editText.setText(str+"3");
                break;
            case R.id.btnClear:
                editText.setText("");
                break;
        }
    }
}