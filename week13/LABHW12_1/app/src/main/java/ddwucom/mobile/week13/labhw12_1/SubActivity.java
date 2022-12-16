package ddwucom.mobile.week13.labhw12_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView(R.layout.activity_sub);

        EditText editText = findViewById (R.id.editText1);

        Intent intent = getIntent();
        String data = intent.getStringExtra("input");
        editText.setText(data);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.button1:
                finish();
                break;
        }
    }
}
