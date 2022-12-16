package ddwucom.mobile.exam02.jungchaewon;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate is started");

        // TextView myText = new TextView(this);
        // myText.setText("안녕 반가워");
        // setContentView(myText);

    }
}