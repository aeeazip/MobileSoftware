package ddwucom.mobile.week13.activityTest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    TextView textView;
    // TextView textView = (TextView)findViewById(R.id.textView);
    // 멤버변수로 만들어서 사용하면 오류남 why??????????

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        String data = intent.getStringExtra("subject");


        int time = intent.getIntExtra("time", 2);
        DataClass dataClass = (DataClass) intent.getSerializableExtra("dataClass"); // 타입 캐스팅 필요

        textView = findViewById(R.id.textView);
        textView.setText(data);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.sub_button_ok:
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result_data", "SubActivity returns data");
                setResult(RESULT_OK, resultIntent);
                break;
            case R.id.sub_button_cancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}
