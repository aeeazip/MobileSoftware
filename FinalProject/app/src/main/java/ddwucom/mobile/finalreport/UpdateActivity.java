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

public class UpdateActivity extends AppCompatActivity {
    MyData myData;
    ImageView image;
    RadioButton shin, chapagetti, hotchicken, samyang, raccoon;
    EditText brand, price, review;
    MyDBManager dbManager;

    String is_checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.update_activity);
        myData = (MyData) getIntent ().getSerializableExtra ("Data");
        dbManager = new MyDBManager(this);

        image = findViewById (R.id.update_image);
        brand = findViewById (R.id.update_brand);
        price = findViewById (R.id.update_price);
        review = findViewById (R.id.update_review);

        shin = findViewById (R.id.update_shin);
        chapagetti = findViewById (R.id.update_chapagetti);
        hotchicken = findViewById (R.id.update_hotchicken);
        samyang = findViewById (R.id.update_samyang);
        raccoon = findViewById (R.id.update_raccoon);

        image.setImageResource (R.mipmap.shin); // 기본값

        shin.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chapagetti.isChecked ())
                    image.setImageResource (R.mipmap.chapagetti);
                else if (hotchicken.isChecked ())
                    image.setImageResource (R.mipmap.hotchicken);
                else if (samyang.isChecked ())
                    image.setImageResource (R.mipmap.samyang);
                else if (raccoon.isChecked ())
                    image.setImageResource (R.mipmap.raccoon);
            }
        });

        chapagetti.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (shin.isChecked ())
                    image.setImageResource (R.mipmap.chapagetti);
                else if (hotchicken.isChecked ())
                    image.setImageResource (R.mipmap.hotchicken);
                else if (samyang.isChecked ())
                    image.setImageResource (R.mipmap.samyang);
                else if (raccoon.isChecked ())
                    image.setImageResource (R.mipmap.raccoon);
            }
        });

        hotchicken.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chapagetti.isChecked ())
                    image.setImageResource (R.mipmap.chapagetti);
                else if (shin.isChecked ())
                    image.setImageResource (R.mipmap.hotchicken);
                else if (samyang.isChecked ())
                    image.setImageResource (R.mipmap.samyang);
                else if (raccoon.isChecked ())
                    image.setImageResource (R.mipmap.raccoon);
            }
        });

        raccoon.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chapagetti.isChecked ())
                    image.setImageResource (R.mipmap.chapagetti);
                else if (hotchicken.isChecked ())
                    image.setImageResource (R.mipmap.hotchicken);
                else if (samyang.isChecked ())
                    image.setImageResource (R.mipmap.samyang);
                else if (shin.isChecked ())
                    image.setImageResource (R.mipmap.raccoon);
            }
        });

        samyang.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chapagetti.isChecked ())
                    image.setImageResource (R.mipmap.chapagetti);
                else if (hotchicken.isChecked ())
                    image.setImageResource (R.mipmap.hotchicken);
                else if (shin.isChecked ())
                    image.setImageResource (R.mipmap.samyang);
                else if (raccoon.isChecked ())
                    image.setImageResource (R.mipmap.raccoon);
            }
        });


        is_checked = myData.getName ();
        if (shin.isChecked () || raccoon.isChecked () || samyang.isChecked () || chapagetti.isChecked () || hotchicken.isChecked ())
            change (is_checked);

        brand.setHint (myData.getCompany ());
        price.setHint (myData.getPrice ());
        review.setHint (myData.getExplanation ());
    }

    public void change(String is_checked) {
        switch (is_checked) {
            case "shin":
                shin.setChecked (true);
                image.setImageResource (R.mipmap.shin);
                break;
            case "raccoon":
                raccoon.setChecked (true);
                image.setImageResource (R.mipmap.raccoon);
                break;
            case "samyang":
                samyang.setChecked (true);
                image.setImageResource (R.mipmap.samyang);
                break;
            case "hotchicken":
                hotchicken.setChecked (true);
                image.setImageResource (R.mipmap.hotchicken);
                break;
            case "chapagetti":
                chapagetti.setChecked (true);
                image.setImageResource (R.mipmap.chapagetti);
                break;
        }
    }

    public void onClick(View v) {
        switch (v.getId ()) {
            case R.id.btn_update:
                // 항목 다 채웠는지 검사 후에 DB 저장 -> Main으로 복귀
                String str = review.getText ().toString ();
                String company = brand.getText ().toString ();
                String update_price = price.getText ().toString ();

                if (company.equals ("") || company == null) {
                    Toast.makeText (UpdateActivity.this, "제조사를 입력하시오", Toast.LENGTH_SHORT).show ();
                    break;
                }

                if (update_price.equals ("") || update_price == null) {
                    Toast.makeText (UpdateActivity.this, "가격 입력하시오", Toast.LENGTH_SHORT).show ();
                    break;
                }

                if (str.equals ("") || str == null) {
                    Toast.makeText (UpdateActivity.this, "맛 평가를 입력하시오", Toast.LENGTH_SHORT).show ();
                    break;
                }


                if (shin.isChecked ())
                    is_checked = "shin";
                else if (raccoon.isChecked ())
                    is_checked = "raccoon";
                else if (samyang.isChecked ())
                    is_checked = "samyang";
                else if (hotchicken.isChecked ())
                    is_checked = "hotchicken";
                else
                    is_checked = "chapagetti";


                myData.setName (is_checked);
                myData.setImageSrc (is_checked);
                myData.setPrice (update_price);
                myData.setCompany (company);
                myData.setExplanation (str);

                if (dbManager.modifyFood (myData)) {
                    Intent resultIntent = new Intent ();
                    resultIntent.putExtra ("foodName", "shin");
                    setResult (RESULT_OK, resultIntent);
                } else {
                    setResult (RESULT_CANCELED);
                }
                finish ();
                break;
            case R.id.btn_cancel:
                setResult (RESULT_CANCELED);
                finish ();
                break;
        }
    }
}
