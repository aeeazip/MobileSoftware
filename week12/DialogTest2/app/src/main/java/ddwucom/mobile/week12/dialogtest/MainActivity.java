package ddwucom.mobile.week12.dialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DataManager dataManager;
    ListView listView;
    ArrayAdapter adapter;
    ArrayList<Food> foodList;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        dataManager = new DataManager();
        foodList = dataManager.getFoodList();

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
                        .setMessage (foodName + "을(를) 삭제하시겠습니까?")
                        .setIcon (R.mipmap.ic_launcher)
                        .setCancelable (false)
                        .setPositiveButton ("삭제", new DialogInterface.OnClickListener () {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //삭제 기능 구현
                                foodList.remove (position);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton ("취소", null)
                        .show ();
                return false;
            }
        });

        button = findViewById (R.id.button);
        button.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                final ConstraintLayout layout = (ConstraintLayout) View.inflate(MainActivity.this, R.layout.custom_layout, null);

                AlertDialog.Builder builder = new AlertDialog.Builder (MainActivity.this);
                builder.setTitle("음식 추가")
                        .setView(layout)
                        .setPositiveButton("추가", new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                EditText food = layout.findViewById (R.id.food);
                                EditText nation = layout.findViewById (R.id.nation);

                                //Toast.makeText(MainActivity.this, food.getText().toString () + nation.getText ().toString (), Toast.LENGTH_SHORT).show();
                               dataManager.addFood(food.getText().toString(), nation.getText().toString());
                               adapter.notifyDataSetChanged ();
                            }
                        })
                        .setNegativeButton ("취소", null)
                        .show ();

            }
        });
    }
}