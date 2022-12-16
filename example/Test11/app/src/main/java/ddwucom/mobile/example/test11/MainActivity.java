package ddwucom.mobile.example.test11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Food> list;
    private ArrayAdapter adapter;
    private ListView listView;
    private FoodManager foodManager;
    private Button button;
    final static int SUB_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        foodManager = new FoodManager();
        list = foodManager.getList();
        listView = findViewById (R.id.listView);

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        button = findViewById (R.id.button);
        button.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivityForResult(intent, SUB_CODE);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode){
            case SUB_CODE:
                if(resultCode == RESULT_OK){
                    Food food = (Food)data.getSerializableExtra("newFood");
                    foodManager.add(food);
                    adapter.notifyDataSetChanged();
                }
                break;
        }
    }

}