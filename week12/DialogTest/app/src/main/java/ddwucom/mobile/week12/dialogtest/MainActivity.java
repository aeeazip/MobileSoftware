package ddwucom.mobile.week12.dialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int selectedIndex = 0;
    boolean[] selectedItems = new boolean[]{false, false, false, false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
    }

   public void onClick(View v){
        final ConstraintLayout orderLayout = (ConstraintLayout)View.inflate(this, R.layout.order_layout, null);

        String[] array = new String[]{"짜장면", "짬뽕"};

        switch(v.getId()){
            case R.id.btn:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setView(orderLayout);
                builder.setTitle("대화상자 제목");
                //builder.setMessage("대화상자 메세지");

                builder.setItems(R.array.foods, new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String[] foods = getResources().getStringArray(R.array.foods);
                        Toast.makeText(MainActivity.this, "선택: " + foods[i], Toast.LENGTH_SHORT).show();
                    }
                });

                // 라디오 버튼을 갖고 있는 목록 출력
                builder.setSingleChoiceItems(R.array.foods, selectedIndex, new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        selectedIndex = i;
                    }
                });

                builder.setMultiChoiceItems(R.array.foods, selectedItems,
                        new DialogInterface.OnMultiChoiceClickListener(){

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                selectedItems[i] = b;
                            }
                        });

                builder.setIcon(R.mipmap.ic_launcher);
                builder.setCancelable(false);
                builder.setPositiveButton("확인버튼", new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                EditText editText = orderLayout.findViewById(R.id.etProduct);
                                String product = editText.getText().toString();
                                Toast.makeText(MainActivity.this, product, Toast.LENGTH_SHORT).show();
                            }
                        });

                builder.setNeutralButton("대기버튼", null);
                builder.setNegativeButton("취소버튼", null);


                //Dialog dlg = builder.create();
                //dlg.show();
                builder.show();

                break;
        }
   }

}

