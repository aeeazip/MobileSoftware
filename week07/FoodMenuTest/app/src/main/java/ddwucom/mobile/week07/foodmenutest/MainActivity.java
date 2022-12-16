package ddwucom.mobile.week07.foodmenutest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu (menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.item01:
                Toast.makeText(this, "짜장면", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item02:
                Toast.makeText(this, "짬뽕", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item03:
                Toast.makeText(this, "김치찌개", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item04:
                Toast.makeText(this, "순두부찌개", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected (item);
    }

    /*
    public void onMenuItemClick(MenuItem item){
        //Toast로 출력
    }
    */
}