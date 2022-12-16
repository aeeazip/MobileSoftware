package ddwucom.mobile.week03.viewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    EditText editText = findViewById(R.id.editText);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //    TextView textview = findViewById(R.id.textView);
    //    textview.setText("cooling");
    }

    public void onClick(View v) {

        switch(v.getId()){
            case R.id.button_ok:

               // String text = editText.getText().toString();
                editText.setText("모바일 소프트웨어");
               // Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
                break;
        }
    }


}