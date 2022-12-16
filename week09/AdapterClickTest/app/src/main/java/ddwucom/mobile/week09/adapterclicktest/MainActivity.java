package ddwucom.mobile.week09.adapterclicktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FoodManager foodManager = new FoodManager();
    ArrayList<String> foodList;
    ArrayAdapter<String> adapter;

    int pos; // 클릭한 항목의 위치를 저장

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        foodList = foodManager.getFoodList(); // 원본 데이터 준비

        // 어댑터 생성
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foodList);

        // 어댑터 뷰 준비 및 어댑터 연결
        ListView listView = findViewById (R.id.listView);
        listView.setAdapter(adapter);

        // 클릭 이벤트 (EditText에 클릭한 항목 표시)
        listView.setOnItemClickListener(clickItem);

        // 롱클릭 이벤트 (삭제)
        listView.setOnItemLongClickListener(longClickItem);
    }

    AdapterView.OnItemClickListener clickItem =
            new AdapterView.OnItemClickListener(){

                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    EditText editText = findViewById(R.id.editText);
                    editText.setText(foodManager.getFood(i));

                    pos = i;
                    adapter.notifyDataSetChanged();
                }
            };

    AdapterView.OnItemLongClickListener longClickItem =
            new AdapterView.OnItemLongClickListener(){

                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                    foodManager.removeFood(i);
                    adapter.notifyDataSetChanged();
                    return false;
                }
            };

    public void onClick(View v){
        EditText editText = findViewById (R.id.editText);
        String str = editText.getText().toString();

        switch(v.getId()){
            case R.id.add:
                if(str.length() != 0)
                    foodManager.addFood(str);
                break;
            case R.id.modify:
                foodList.set(pos, str);
                break;
        }

        adapter.notifyDataSetChanged();
        editText.setText(""); // 추가 or 수정 후 EditText 비워주기
    }
}