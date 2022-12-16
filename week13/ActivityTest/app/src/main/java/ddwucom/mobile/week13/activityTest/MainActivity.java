package ddwucom.mobile.week13.activityTest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final static int SUB_ACTIVITY_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
    }

    public void onClick(View v){
        switch(v.getId()) {
            case R.id.button:

                // 객체를 인텐트로 연결하기 위해 만든 Dataclass 객체
                DataClass dataClass = new DataClass();


                Intent intent = new Intent (this, SubActivity.class); // MainActivity에서 SubActivity로 인텐트 전달
                intent.putExtra("subject", "mobile software"); // 인텐트에 mobile software라는 value를 가진 subject 만들기


                intent.putExtra("time", 3);
                intent.putExtra("dataClass", dataClass); // 객체를 인텐트로 넣고 싶을 땐 Serializable 상속 받으면 됌


                startActivity (intent); // 액티비티를 실행 -> 버튼을 클릭하면 SubActivity 실행
                startActivityForResult(intent, SUB_ACTIVITY_CODE); // 결과를 위해 액티비를 실행한다 (Sub에서 자료를 만들어서 Main으로 보내준다.)


                // 외부의 정보를 인텐트로 전달하는 경우 -> 웹사이트를 보여주기 위해 웹뷰를 연결
                // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                // startActivity(intent);

                // 외부의 정보를 인텐트로 전달하는 경우 -> 전화번호와 관련된 정보를 보여주기 위해 dial을 연결
                // Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:012-3456-7890"));
                // startActivity(intent);

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // 매개변수 requestCode = 어떤 액티비티에서 자료를 저달해주는지 구별하기 위해 사용하는 SUB_ACTIVITY_CODE
        // 매개변수 resultCode = RESULT_OK / RESULT_CANCEL (결과 제대로 생성 OR NOT)
        super.onActivityResult (requestCode, resultCode, data);

        switch(requestCode){
            case SUB_ACTIVITY_CODE:
                    if(resultCode == RESULT_OK){
                        String resultData = data.getStringExtra("result_data"); // 인텐트로 전달받은 result_data 꺼내기
                        Toast.makeText(this, "Result: " + resultData, Toast.LENGTH_SHORT).show();
                        //Log.i("MainActivity", "Result: " + resultData);
                    }
                    break;
        }
    }
}