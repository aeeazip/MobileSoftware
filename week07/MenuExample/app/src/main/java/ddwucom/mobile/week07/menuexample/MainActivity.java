package ddwucom.mobile.week07.menuexample;

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

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }


   public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        getMenuInflater().inflate(R.menu.menu1_main, menu);
   }

    public boolean onOptionsItemSelected(MenuItem item){
        MyCircle myCircle = findViewById(R.id.myCircle);

        switch(item.getItemId()){
            case R.id.bigger:
                myCircle.size = 100;
                myCircle.invalidate();
                break;
            case R.id.smaller:
                myCircle.size = 50;
                myCircle.invalidate();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onContextItemSelected(MenuItem item){
        MyCircle myCircle = findViewById(R.id.myCircle);

        switch(item.getItemId()){
            case R.id.red:
                myCircle.color = Color.RED;
                myCircle.invalidate();
                break;
            case R.id.green:
                myCircle.color = Color.GREEN;
                myCircle.invalidate();
                break;
            case R.id.blue:
                myCircle.color = Color.BLUE;
                myCircle.invalidate();
                break;
        }
        return super.onContextItemSelected(item);
    }
}