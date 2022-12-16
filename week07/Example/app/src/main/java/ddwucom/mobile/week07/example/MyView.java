package ddwucom.mobile.week07.example;

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
    Random random = new Random();

    int num;

    public MyView(Context context) {
        super (context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super (context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super (context, attrs, defStyleAttr);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super (context, attrs, defStyleAttr, defStyleRes);
    }

    public void onDraw(Canvas canvas){
        int x = random.nextInt(500);
        int y = random.nextInt(800);
        int r = (random.nextInt(3) + 1) * 100;

        canvas.drawColor(Color.YELLOW);

        if(count > 0){
            Paint pnt = new Paint();
            pnt.setColor(Color.CYAN);

            canvas.drawCircle(x, y, r, pnt);
        }
        count++;
    }
}
