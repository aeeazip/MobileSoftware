package ddwucom.mobile.week05.exam02;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Random;

public class MyView extends View {
    static int count = 0;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void onDraw(Canvas canvas){
        canvas.drawColor(Color.YELLOW);
        count++;

        if(count>1) {
            Random random = new Random();

            int x, y, r;
            x = random.nextInt(500);
            y = random.nextInt(800);
            r = (random.nextInt(3) + 1) * 100;

            canvas.drawColor(Color.YELLOW);
            Paint paint = new Paint();
            paint.setColor(Color.CYAN);
            canvas.drawCircle(x, y, r, paint);
        }
    }
}
