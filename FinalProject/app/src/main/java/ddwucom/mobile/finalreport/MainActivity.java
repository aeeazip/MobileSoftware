package ddwucom.mobile.finalreport;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final int REQ_CODE = 100;
    final int UPDATE_CODE = 200;

    ListView listView;
    MyAdapter adapter;
    ArrayList<MyData> list;
    MyDBHelper dbHelper;
    MyDBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        listView = findViewById (R.id.listView);
        list = new ArrayList<MyData> ();
        dbHelper = new MyDBHelper (this);
        adapter = new MyAdapter (this, R.layout.custom_adapter_view, list);
        listView.setAdapter (adapter);
        dbManager = new MyDBManager (this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener (){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MyData mydata = list.get(i);

                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                intent.putExtra("Data", mydata);
                startActivityForResult (intent, UPDATE_CODE);
            }
        });

        listView.setOnItemLongClickListener (new AdapterView.OnItemLongClickListener (){

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int position = i;

                MyData mydata = list.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle ("리뷰 삭제")
                        .setMessage ("번호 " + mydata.get_id () + " " + mydata.getName () + " 리뷰를 삭제하시겠습니까?")
                        .setPositiveButton ("삭제", new DialogInterface.OnClickListener () {

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                boolean result = dbManager.removeFood(mydata.get_id());

                                if (result) {
                                    Toast.makeText (MainActivity.this, "삭제 완료", Toast.LENGTH_SHORT).show ();
                                    onResume();
                                }
                                else
                                    Toast.makeText (MainActivity.this, "삭제 실패", Toast.LENGTH_SHORT).show ();
                            }
                        })
                        .setNegativeButton ("취소", null)
                        .setCancelable(false)
                        .show ();

            return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume ();
        list.clear();
        list.addAll(dbManager.getAllFood());
        adapter.notifyDataSetChanged();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater ();
        inflater.inflate (R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        AlertDialog.Builder builder = new AlertDialog.Builder (this);
        switch (item.getItemId ()) {
            case R.id.add:
                Intent intent = new Intent (MainActivity.this, AddActivity.class);
                startActivityForResult (intent, REQ_CODE);
                break;
            case R.id.search:
                builder.setTitle("라면 이름으로 리뷰 검색하시겠습니까?")
                        .setPositiveButton ("확인", new DialogInterface.OnClickListener () {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                                startActivity (intent);
                            }
                        })
                        .setNegativeButton ("취소", null)
                        .show();
                break;
            case R.id.introduction:
                builder.setTitle("개발자 소개")
                        .setView(R.layout.introduce_developer)
                        .setPositiveButton("확인", null)
                        .setNegativeButton("취소", null)
                        .setCancelable (false)
                        .show();
                break;
            case R.id.finish:
                builder.setTitle("앱 종료")
                        .setMessage("앱을 종료하시겠습니까?")
                        .setPositiveButton("종료", new DialogInterface.OnClickListener (){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton("취소", null)
                        .setCancelable (false)
                        .show();
                break;
        }
        return super.onOptionsItemSelected (item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE) {  // AddActivity 호출 후 결과 확인
            switch (resultCode) {
                case RESULT_OK:
                    String food = data.getStringExtra("food");
                    Toast.makeText(this, "추가 완료", Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "추가 취소", Toast.LENGTH_SHORT).show();
                    break;
            }
        } else if (requestCode == UPDATE_CODE) {    // UpdateActivity 호출 후 결과 확인
            switch (resultCode) {
                case RESULT_OK:
                    Toast.makeText(this, "수정 완료", Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "수정 취소", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
