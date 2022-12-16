package ddwucom.mobile.week03.HW1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        EditText etName = (EditText)findViewById(R.id.etName);
        EditText etPhone = (EditText)findViewById(R.id.etPhone);

        switch(v.getId()){
            case R.id.btnHello:
                    String name = etName.getText().toString();
                    String phone = etPhone.getText().toString();

                    String text = "안녕하세요, 저는 " + name + " 입니다.\n전화번호는 " + phone + "입니다.";
                    Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
                    break;
            case R.id.btnExit:
                    finish();
                    break;
        }
    }
}