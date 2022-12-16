package ddwucom.mobile.week06.hw2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {

    float x = -1, y = -1;  // 어떤 위치도 터치하지 않았을 때의 초기 좌표
    int color;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public MyView(Context context) {
        super(context);
        setColor(Color.RED);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setColor(Color.RED);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setColor(Color.RED);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setColor(Color.RED);
    }

    /*
    //1. MyView 클래스에 onTouchEvent 메소드 오버라이딩

     public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            // 누른 곳의 x, y 좌표 가져 오기
            x = event.getX();
            y = event.getY();
            invalidate(); // 이벤트가 발생하도록 갱신하도록
        }
        return false;
    }
    */


    public void onDraw(Canvas canvas){
        canvas.drawColor(Color.GRAY);

        if(x != -1 && y != -1){
            Paint paint = new Paint();
            paint.setColor(color);
            canvas.drawCircle(x, y, 30, paint);
        }
    }
}
