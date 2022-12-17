package ddwucom.mobile.finalreport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    ArrayList<MyData> list;
    MyDBHelper dbHelper;
    MyDBManager dbManager;
    MyAdapter adapter;
    ListView listView;
    RadioButton shin, chapagetti, hotchicken, samyang, raccoon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.search_activity);

        // list = new ArrayList<MyData>();
        dbManager = new MyDBManager(this);

        String is_checked;
        shin = findViewById (R.id.search_shin);
        chapagetti = findViewById (R.id.search_chapagetti);
        hotchicken = findViewById (R.id.search_hotchicken);
        samyang = findViewById (R.id.search_samyang);
        raccoon = findViewById (R.id.search_raccoon);

    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.search_now:
                String is_checked;

                if(shin.isChecked())
                    is_checked = "shin";
                else if(raccoon.isChecked ())
                    is_checked = "raccoon";
                else if(hotchicken.isChecked ())
                    is_checked = "hotchicken";
                else if(samyang.isChecked ())
                    is_checked = "samyang";
                else
                    is_checked = "chapagetti";

                list = dbManager.getFoodsByName(is_checked);
                adapter = new MyAdapter(this, R.layout.custom_adapter_view, list);
                listView = findViewById (R.id.search_listView);
                listView.setAdapter(adapter);
                break;
            case R.id.back:
                finish();
                break;
        }
    }
}
