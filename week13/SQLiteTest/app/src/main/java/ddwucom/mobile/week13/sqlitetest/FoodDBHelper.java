package ddwucom.mobile.week13.sqlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class FoodDBHelper extends SQLiteOpenHelper {
    final static String TAG="FoodDBHelper";
    final static String DB_NAME = "foods.db";
    // table 명과 column명은 public 상수로 선언 -> 외부에서 접근 가능
    public final static String TABLE_NAME="food_table";
    public final static String COL_ID = "_id";
    public final static String COL_FOOD = "food";
    public final static String COL_NATION = "nation";
    
    public FoodDBHelper(Context context){
        // version 값을 매개변수로 전달 받을 경우 값이 달라지면 onUpgrade 자동 호출
        super(context, DB_NAME, null, 1);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement, " + COL_FOOD + " TEXT, " + COL_NATION + " TEXT)";
        Log.d(TAG, sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db); // 테이블 구조 변경 시 수정 후 -> onCreate 호출
    }
}
