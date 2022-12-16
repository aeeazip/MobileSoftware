package ddwucom.mobile.example.test9;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Food> list;
    private ListView listView;
    private ArrayAdapter adapter;
    private FoodManager foodManager;
    private int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        foodManager = new FoodManager();
        list = foodManager.getList();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView = findViewById (R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                position = i;

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("음식삭제")
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false)
                        .setMessage(list.get(position).getFoodName() + "을(를) 삭제하시겠습니까?")
                        .setPositiveButton("확인", new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                foodManager.removeList(position);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();
                // Dialog.setCancelOnTouchOutSide(false);
                return false;
            }
        });

        Button button = findViewById (R.id.button);
        button.setOnClickListener(new Button.OnClickListener(){
           public void onClick(View view){
                final ConstraintLayout layout = (ConstraintLayout) View.inflate(MainActivity.this, R.layout.custom, null);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("음식추가")
                        .setView(layout)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                EditText food = layout.findViewById (R.id.food);
                                EditText nation = layout.findViewById (R.id.nation);

                                foodManager.add(new Food(food.getText().toString(), nation.getText().toString()));
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();
           }
        });
    }
}