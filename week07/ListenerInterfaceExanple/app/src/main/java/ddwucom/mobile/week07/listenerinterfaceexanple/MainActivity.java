package ddwucom.mobile.week07.listenerinterfaceexanple;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        MyView myView = findViewById(R.id.myView);
        myView.setOnTouchListener(new View.OnTouchListener (){

            @Override
            public boolean onTouch(View view, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    // 누른 곳의 x, y 좌표 가져 오기
                    myView.x = event.getX();
                    myView.y = event.getY();
                    myView.setColor(Color.RED);
                    myView.invalidate(); // 이벤트가 발생하면 갱신하도록
                }
                return false;
            }
        });


        myView.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
                myView.setColor(Color.BLACK);
                myView.invalidate();

                return false;
            }
        });
    }
}

