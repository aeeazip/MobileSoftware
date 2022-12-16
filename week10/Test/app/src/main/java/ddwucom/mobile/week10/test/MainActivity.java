package ddwucom.mobile.week10.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DataManager dataManager;
    private ArrayList<MyData> myDataList;
    private MyAdapter adapter;
    private ListView listView;
    final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        dataManager = new DataManager ();
        myDataList = dataManager.getDataList ();

        adapter = new MyAdapter (this, R.layout.custom_adapter_view, myDataList);

        listView = findViewById (R.id.listView);
        listView.setAdapter (adapter);

        listView.setOnItemLongClickListener(longClickItem);
    }

    AdapterView.OnItemLongClickListener longClickItem =
            new AdapterView.OnItemLongClickListener(){

                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                    myDataList.remove(i); //dataManager.remove(i);
                    adapter.notifyDataSetChanged();
                    return false;
                }
            };

}