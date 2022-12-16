package ddwucom.mobile.week05.myviewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {

    int color;

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public MyView(Context context) {
        super(context);
        setColor(Color.BLUE);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setColor(Color.BLUE);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setColor(Color.BLUE);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.LTGRAY);
        Paint Pnt = new Paint();
        Pnt.setColor(color);
        canvas.drawCircle(100,100,80,Pnt);

        canvas.drawCircle(200,200,160,Pnt);
    }
}
