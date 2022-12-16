package ddwucom.mobile.week12.exam01;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

import ddwucom.mobile.week12.exam01.Food;
import ddwucom.mobile.week12.exam01.R;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;
    ArrayList<Food> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        // DataManager 적용해 볼 것
        foodList = new ArrayList<Food>();
        foodList.add(new Food("김치찌개", "한국"));
        foodList.add(new Food("된장찌개", "한국"));
        foodList.add(new Food("훠궈", "중국"));
        foodList.add(new Food("딤섬", "중국"));
        foodList.add(new Food("초밥", "일본"));
        foodList.add(new Food("오코노미야키", "일본"));

        // Food 객체의 toString() 메소드가 호출되어 하나의 문자열로 처리됨
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, foodList);

        listView.setAdapter(adapter);

        // listView 롱클릭 이벤트 추가
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long l) {
                final int position = pos;

                AlertDialog.Builder builder = new AlertDialog.Builder (MainActivity.this);
                String foodName = foodList.get (pos).getFood ();
                builder.setTitle ("음식삭제")
                        .setMessage (foodName + "을(를)")
                        .setIcon (R.mipmap.ic_launcher)
                        .setCancelable (false)
                        .setPositiveButton ("확인버튼", new DialogInterface.OnClickListener () {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //삭제 기능 구현
                                foodList.remove (i);
                            }
                        })
                        .setNegativeButton ("취소버튼", null)
                        .show ();
                return false;
            }
        });
    }

    public void onClick(View v) {
        Toast.makeText(this, "기능 구현 후 토스트는 삭제", Toast.LENGTH_SHORT).show();
    }
}