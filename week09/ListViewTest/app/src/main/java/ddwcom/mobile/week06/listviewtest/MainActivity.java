package ddwcom.mobile.week06.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DataManager dataManager = new DataManager();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ArrayList<String> subjectList = dataManager.getSubjectList();

        // 어댑터 생성 -> 화면 만들 준비 끝
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, subjectList); // 원본 데이터와 레이아웃 전달
        
        // 어댑터 뷰 준비 및 어댑터 연결
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter); // 위에서 만든 어댑터 매개변수로 넣어주기

        //클릭이벤트 처리
       listView.setOnItemClickListener(itemClickListener);

    }



    AdapterView.OnItemClickListener itemClickListener =
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                    Toast.makeText(MainActivity.this
                            , dataManager.getSubject(pos)
                            , Toast.LENGTH_SHORT).show();

                    //dataManager.removeData(pos);
                    //adapter.notifyDataSetChanged();
                }
        };




}