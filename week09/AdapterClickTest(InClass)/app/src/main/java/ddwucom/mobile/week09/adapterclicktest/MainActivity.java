package ddwucom.mobile.week09.adapterclicktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnInsert:
                // 요런 로직으로 작성해라 참고만 하기~~
                subjectManager.addData(editText.getText().toString());
                adapter.notifyDataSetChanged();
                break;
            // 수정은 클릭한 순간 발생 pos은 멤버변수로 만들어서 기억해놓기
            
        }
    }
}