package ddwucom.mobile.week06.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        2-1

        Button myBtn = findViewById(R.id.btnDisplay);
        MyClick myClick = new MyClick();

        myBtn.setOnClickListener(myClick);
         */

        /*
        2-4

        Button myBtn = findViewById(R.id.btnDisplay);
        myBtn.setOnClickListener(clickListener);
         */


        /*
        2-5

        Button myBtn = findViewById(R.id.btnDisplay);
        myBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                EditText editText = findViewById(R.id.editText);
                TextView textView = findViewById(R.id.tvDisplay);

                String str = editText.getText().toString();
                textView.setText(str);
            }
        });

         */
    }

    /*
    2-1

    class MyClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            EditText editText = findViewById(R.id.editText);
            TextView textView = findViewById(R.id.tvDisplay);

            String str = editText.getText().toString();
            textView.setText(str);
        }
    }
     */

    /*
    2-4

    View.OnClickListener clickListener = new View.OnClickListener(){
        public void onClick(View view) {
            EditText editText = findViewById(R.id.editText);
            TextView textView = findViewById(R.id.tvDisplay);

            String str = editText.getText().toString();
            textView.setText(str);
        }
    };
     */
}

