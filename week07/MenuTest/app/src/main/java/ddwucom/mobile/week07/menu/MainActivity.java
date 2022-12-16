package ddwucom.mobile.week07.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean[] checkedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        checkedItem = new boolean[2]; // checked 표시할 배열 2개 크기로 만들기
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu (menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.item01:
                Toast.makeText(this, "첫번쨰 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.subItem01:
                break;
        }
        return super.onOptionsItemSelected (item);
    }

    public void onMenuClick(MenuItem item){
        Toast.makeText(this, "첫번쨰 클릭", Toast.LENGTH_SHORT).show();
    }

    public void onMenuClick1(MenuItem item){
        switch(item.getItemId()){
            case R.id.radio01:
                item.setChecked(true);
                break;
            case R.id.radio02:
                item.setChecked(true);
                break;
        }
    }

    public void onCheckClick(MenuItem item){
        switch(item.getItemId()){
            case R.id.check01:
                if(item.isChecked())
                    checkedItem[0]=false;
                else
                    checkedItem[0]=true;
                item.setChecked(checkedItem[0]);
                break;
            case R.id.check02:
                if(item.isChecked())
                    checkedItem[1]=false;
                else
                    checkedItem[1]=true;
                item.setChecked(checkedItem[0]);
                break;
        }
    }
}