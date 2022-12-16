package ddwucom.mobile.week05.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SoundPool soundPool;
    int sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        sound = soundPool.load(this, R.raw.dingdong, 1);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnToast:
                Toast.makeText(this, "정채원", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSound:
                soundPool.play(sound, 1,1,0,0,1);
                break;
            case R.id.btnVibration:
                Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

                vibrator.vibrate(500);
                vibrator.vibrate(new long[] {100,50,200,50}, 0);
                break;
        }
    }
}