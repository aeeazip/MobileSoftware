package ddwucom.mobile.week05.myviewtest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //MyView vw = new MyView(this);
        //setContentView(vw);

    }

    public void onClick(View v){

        MyView myView = findViewById(R.id.myView);
        myView.setColor(Color.RED);
        myView.invalidate();
    }
}