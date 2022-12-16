package ddwucom.mobile.week07.menuexample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyCircle extends View {
    int size = 50;
    int color = Color.RED;

    public void setColor(int color) {
        this.color = color;
    }

    public void setSize(int size){
        this.size = size;
    }

    public MyCircle(Context context) {
        super (context);
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs) {
        super (context, attrs);
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super (context, attrs, defStyleAttr);
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super (context, attrs, defStyleAttr, defStyleRes);
    }

    public void onDraw(Canvas canvas){
        Paint pnt = new Paint();
        pnt.setColor(color);
        canvas.drawCircle(300,300,size,pnt);
    }
}
