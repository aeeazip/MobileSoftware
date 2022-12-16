package ddwucom.mobile.week07.mycircletest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyCircle extends View {
    int count = 0;
    int color;
    int radius = 100;

    public void setColor(int color) {
        this.color = color;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getColor() {
        return color;
    }

    public int getRadius() {
        return radius;
    }

    public MyCircle(Context context) {
        super (context);
        setColor(Color.RED);
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs) {
        super (context, attrs);
        setColor(Color.RED);
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super (context, attrs, defStyleAttr);
        setColor(Color.RED);
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super (context, attrs, defStyleAttr, defStyleRes);
        setColor(Color.RED);
    }

    public void onDraw(Canvas canvas){
        if(count >= 1){
            Paint paint = new Paint();
            paint.setColor(color);
            canvas.drawCircle(500,500, getRadius(), paint);
        }
        count++;
    }
}
