package ddwucom.mobile.week10.customadaptertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DataManager dataManager;
    private ArrayList<MyData> myDataList;
    private MyAdapter myAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        myDataList = dataManager.getDataList(); // DataManager 클래스에서 원본 데이터 가져오기
        myAdapter = new MyAdapter(this, R.layout.custom_adapter_view, myDataList);

        listView = findViewById (R.id.listView);
        listView.setAdapter(myAdapter);


        /*
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener (){

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                myDataList.remove(i);
                myAdapter.notifyDataSetChanged();
                return false;
            }
        });
         */
    }
}