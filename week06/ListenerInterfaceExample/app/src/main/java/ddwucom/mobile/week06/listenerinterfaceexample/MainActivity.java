package ddwucom.mobile.week06.listenerinterfaceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //invalidateOptionsMenu();

        /*

        2.1 별도의 리스너 인터페이스 구현 클래스 작성
        MyTouch myTouch = new MyTouch();

        Button button = findViewById(R.id.button);
        button.setOnTouchListener(myTouch);

         */

        /*

        2.2 Activity가 리스너 인터페이스 직접 구현 (class MainActivity가 OnLongClickListener implements 하도록)

        Button button = findViewById(R.id.button);
        button.setOnLongClickListener(this);
         */

        /*

        2.4 익명 내부 클래스로 구현

        Button button = findViewById(R.id.button);
        button.setOnLongClickListener(onLongClickListener);
         */

        /*

        2.5 익명 내부 클래스의 임시 객체로 구현

        Button button = findViewById(R.id.button);
        button.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this, "LongClick", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        */


    }




    /*
    2.1 별도의 리스터 인터페이스 구현 클래스 작성

    class MyTouch implements View.OnTouchListener{

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Toast.makeText(MainActivity.this, "Touch", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

     */

    /*

     2.2 Activity가 리스너 인터페이스 직접 구현

    @Override
    public boolean onLongClick(View view) {
        Toast.makeText(this, "LongClick", Toast.LENGTH_SHORT).show();
        return false;
    }
     */

    /*

    2.4 익명 내부 클래스로 구현

    View.OnLongClickListener onLongClickListener = new View.OnLongClickListener(){
        @Override
        public boolean onLongClick(View view) {
            Toast.makeText(MainActivity.this, "LongClick", Toast.LENGTH_SHORT).show();
            return false;
        }
    };
     */
}