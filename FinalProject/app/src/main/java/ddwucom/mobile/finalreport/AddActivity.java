package ddwucom.mobile.finalreport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    RadioButton shin, chapagetti, hotchicken, samyang, raccoon;
    ImageView image;
    MyDBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.add_activity);

        dbManager = new MyDBManager (this);

        shin = findViewById (R.id.shin);
        chapagetti = findViewById (R.id.chapagetti);
        hotchicken = findViewById (R.id.hotchicken);
        samyang = findViewById (R.id.samyang);
        raccoon = findViewById (R.id.raccoon);
        image = findViewById (R.id.image);
        image.setImageResource (R.mipmap.shin);

        shin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chapagetti.isChecked())
                    image.setImageResource (R.mipmap.chapagetti);
                else if(hotchicken.isChecked())
                    image.setImageResource (R.mipmap.hotchicken);
                else if(samyang.isChecked ())
                    image.setImageResource (R.mipmap.samyang);
                else if(raccoon.isChecked())
                    image.setImageResource (R.mipmap.raccoon);
            }
        });

        chapagetti.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(shin.isChecked())
                    image.setImageResource (R.mipmap.chapagetti);
                else if(hotchicken.isChecked())
                    image.setImageResource (R.mipmap.hotchicken);
                else if(samyang.isChecked ())
                    image.setImageResource (R.mipmap.samyang);
                else if(raccoon.isChecked())
                    image.setImageResource (R.mipmap.raccoon);
            }
        });

        hotchicken.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chapagetti.isChecked())
                    image.setImageResource (R.mipmap.chapagetti);
                else if(shin.isChecked())
                    image.setImageResource (R.mipmap.hotchicken);
                else if(samyang.isChecked ())
                    image.setImageResource (R.mipmap.samyang);
                else if(raccoon.isChecked())
                    image.setImageResource (R.mipmap.raccoon);
            }
        });

        raccoon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chapagetti.isChecked())
                    image.setImageResource (R.mipmap.chapagetti);
                else if(hotchicken.isChecked())
                    image.setImageResource (R.mipmap.hotchicken);
                else if(samyang.isChecked ())
                    image.setImageResource (R.mipmap.samyang);
                else if(shin.isChecked())
                    image.setImageResource (R.mipmap.raccoon);
            }
        });

        samyang.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chapagetti.isChecked())
                    image.setImageResource (R.mipmap.chapagetti);
                else if(hotchicken.isChecked())
                    image.setImageResource (R.mipmap.hotchicken);
                else if(shin.isChecked ())
                    image.setImageResource (R.mipmap.samyang);
                else if(raccoon.isChecked())
                    image.setImageResource (R.mipmap.raccoon);
            }
        });

    }

    public void onClick(View v){
        String is_checked, company, price;

        switch(v.getId()){
            case R.id.btn_update:
                // ?????? ??? ???????????? ?????? ?????? DB ?????? -> Main?????? ??????
                EditText editText = findViewById (R.id.review);
                String str = editText.getText().toString();

                if(str.equals("") || str == null) {
                    Toast.makeText (AddActivity.this, "??? ????????? ???????????????", Toast.LENGTH_SHORT).show ();
                    break;
                }

                if(shin.isChecked()) {
                    is_checked = "shin";
                    company="??????";
                    price="800";
                }
                else if(raccoon.isChecked ()) {
                    is_checked = "raccoon";
                    company = "??????";
                    price = "900";
                }
                else if(samyang.isChecked ()) {
                    is_checked = "samyang";
                    company = "??????";
                    price = "800";
                }
                else if(hotchicken.isChecked()) {
                    is_checked = "hotchicken";
                    company = "??????";
                    price = "1000";
                }
                else{
                    is_checked="chapagetti";
                    company = "??????";
                    price = "950";
                }

                boolean result = dbManager.addNewFood(new MyData(is_checked, company, is_checked, price, editText.getText().toString()));

                if (result) {    // ??????????????? ?????? ?????? (?????? ??????????????? count)
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("food", is_checked);
                    setResult(RESULT_OK, resultIntent);
                    // dbHelper.close();
                    finish();
                } else {        // ????????? ?????? ??????
                    Toast.makeText(this, "????????? ?????? ?????? ??????!", Toast.LENGTH_SHORT).show();
                    // dbHelper.close();
                }
                break;
            case R.id.btn_cancel:
                finish();
                break;
        }
    }
}
