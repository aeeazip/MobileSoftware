package ddwucom.mobile.week07.mycircletest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        MyCircle myCircle = findViewById(R.id.myCircle);
        registerForContextMenu(myCircle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu (menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        MyCircle myCircle = findViewById(R.id.myCircle);

        switch(item.getItemId()){
            case R.id.big:
                myCircle.setRadius(300);
                myCircle.invalidate();
                break;
            case R.id.small:
                myCircle.setRadius(100);
                myCircle.invalidate();
                break;
        }
        return super.onOptionsItemSelected (item);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu (menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main1, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        MyCircle myCircle = findViewById(R.id.myCircle);

        switch(item.getItemId()){
            case R.id.red:
                myCircle.setColor(Color.RED);
                myCircle.invalidate();
                break;
            case R.id.green:
                myCircle.setColor(Color.GREEN);
                myCircle.invalidate();
                break;
            case R.id.blue:
                myCircle.setColor(Color.BLUE);
                myCircle.invalidate();
                break;
        }
        return super.onContextItemSelected (item);
    }



}