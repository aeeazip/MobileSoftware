package ddwucom.mobile.finalreport;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {
    final static String DB_NAME = "foods.db";
    public final static String TABLE_NAME = "food_table";

    public final static String COL_ID = "_id";
    public final static String COL_IMAGE = "image";
    public final static String COL_COMPANY = "company";
    public final static String COL_FOOD = "food";
    public final static String COL_PRICE = "price";
    public final static String COL_EX = "explanation";

    public MyDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement, " +
                COL_IMAGE + " TEXT, " + COL_COMPANY + " TEXT, " + COL_FOOD + " TEXT, " + COL_PRICE + " TEXT, " + COL_EX + " TEXT)";
        db.execSQL(sql);

        insertSample(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertSample(SQLiteDatabase db) {
        db.execSQL("insert into " + TABLE_NAME + " values (null, 'shin', '농심', 'shin', '800', '깔끔한 매운맛');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, 'hotchicken', '삼양', 'hotchicken', '1000', '입에서 불이 나는 매운맛');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, 'raccoon', '농심', 'raccoon', '900', '오동통한 면발');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, 'samyang', '삼양', 'samyang', '800', '클래식한 국물');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, 'chapagetti', '농심', 'chapagetti', '950', '오늘은 내가 요리사');");
    }
}
