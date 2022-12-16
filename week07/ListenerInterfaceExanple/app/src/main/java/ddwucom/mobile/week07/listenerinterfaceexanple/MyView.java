package ddwucom.mobile.week07.listenerinterfaceexanple;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {
    float x = -1, y = -1;
    int color;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public MyView(Context context) {
        super (context);
        setColor(Color.RED);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super (context, attrs);
        setColor(Color.RED);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super (context, attrs, defStyleAttr);
        setColor(Color.RED);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super (context, attrs, defStyleAttr, defStyleRes);
        setColor(Color.RED);
    }

    /*
    public boolean onTouchEvent(MotionEvent motionEvent){
        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
            x = motionEvent.getX();
            y = motionEvent.getY();
            invalidate();
        }
        return true;
    }

     */

    public void onDraw(Canvas canvas){
        canvas.drawColor(Color.GRAY);

        if(x!=-1 && y!=-1){
            Paint pnt = new Paint();
            pnt.setColor(color);
            canvas.drawCircle(x, y, 30, pnt);
        }
    }
}
