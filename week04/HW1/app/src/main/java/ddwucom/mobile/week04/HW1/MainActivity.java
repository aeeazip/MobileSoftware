package ddwucom.mobile.week04.HW1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        LinearLayout layout = (LinearLayout)findViewById(R.id.layout);

        switch(v.getId()){
            case R.id.btn_vertical:
                layout.setOrientation(LinearLayout.HORIZONTAL);
                break;
            case R.id.btn_horizontal:
                layout.setOrientation(LinearLayout.VERTICAL);
                break;
        }
    }
}