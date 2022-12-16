package ddwucom.mobile.week07.contexttest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        registerForContextMenu(textView); // Context메뉴 필요한 View를 등록
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        switch(v.getId()){
            case R.id.textView:
                getMenuInflater().inflate(R.menu.menu_main, menu);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.item01:
                Toast.makeText(this, "item01", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item02:
                Toast.makeText(this, "item02", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected (item);
    }
}