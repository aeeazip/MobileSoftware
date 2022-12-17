package ddwucom.mobile.finalreport;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class MyDBManager {
    MyDBHelper dbHelper;
    Cursor cursor;

    public MyDBManager(Context context) {
        dbHelper = new MyDBHelper(context);
    }

    public ArrayList<MyData> getAllFood(){
        ArrayList<MyData> list = new ArrayList<MyData>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM " + MyDBHelper.TABLE_NAME, null);

        while(cursor.moveToNext()) {
            @SuppressLint("Range") long id = cursor.getInt(cursor.getColumnIndex(MyDBHelper.COL_ID));
            @SuppressLint("Range") String imageSrc = cursor.getString(cursor.getColumnIndex (MyDBHelper.COL_IMAGE));
            @SuppressLint("Range") String company = cursor.getString(cursor.getColumnIndex (MyDBHelper.COL_COMPANY));
            @SuppressLint("Range") String food = cursor.getString(cursor.getColumnIndex(MyDBHelper.COL_FOOD));
            @SuppressLint("Range") String price = cursor.getString(cursor.getColumnIndex (MyDBHelper.COL_PRICE));
            @SuppressLint("Range") String explanation = cursor.getString(cursor.getColumnIndex(MyDBHelper.COL_EX));
            list.add ( new MyData (id, imageSrc, company, food, price, explanation) );
        }

        cursor.close();
        dbHelper.close();

        return list;
    }

    public boolean addNewFood(MyData newFood) {

        SQLiteDatabase db = dbHelper.getWritableDatabase ();
        ContentValues value = new ContentValues ();
        value.put (MyDBHelper.COL_IMAGE, newFood.getImageSrc ());
        value.put (MyDBHelper.COL_COMPANY, newFood.getCompany ());
        value.put (MyDBHelper.COL_FOOD, newFood.getName ());
        value.put (MyDBHelper.COL_PRICE, newFood.getPrice ());
        value.put (MyDBHelper.COL_EX, newFood.getExplanation ());

        // insert 메소드를 사용할 경우 데이터 삽입이 정상적으로 이루어질 경우 1 이상, 이상이 있을 경우 0 반환 확인 가능
        long count = db.insert (MyDBHelper.TABLE_NAME, null, value);

        if (count > 0)
            return true;
        return false;
    }

    public boolean modifyFood(MyData newFood) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put (MyDBHelper.COL_IMAGE, newFood.getImageSrc ());
        value.put (MyDBHelper.COL_COMPANY, newFood.getCompany ());
        value.put (MyDBHelper.COL_FOOD, newFood.getName ());
        value.put (MyDBHelper.COL_PRICE, newFood.getPrice ());
        value.put (MyDBHelper.COL_EX, newFood.getExplanation ());

        String whereClause = MyDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[]{String.valueOf(newFood.get_id())};

        int result = db.update(MyDBHelper.TABLE_NAME, value, whereClause, whereArgs);
        dbHelper.close();

        if(result > 0)
            return true;
        return false;
    }

    public boolean removeFood(long id) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String whereClause = MyDBHelper.COL_ID + "=?";

        String[] whereArgs = new String[]{String.valueOf(String.valueOf(id))};
        int result = sqLiteDatabase.delete(MyDBHelper.TABLE_NAME, whereClause, whereArgs);

        if(result > 0)
            return true;
        return false;
    }

    public ArrayList<MyData> getFoodsByName(String name) {
        ArrayList<MyData> list = new ArrayList<MyData>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String where = "food=?";
        String[] args = new String[]{name};

        //cursor = db.rawQuery("SELECT * FROM " + MyDBHelper.TABLE_NAME + " WHERE " + MyDBHelper.COL_FOOD + "=" + name, null);
        Cursor cursor = db.query(MyDBHelper.TABLE_NAME, null, where, args, null, null, null, null);
        while(cursor.moveToNext()){
            @SuppressLint("Range") long id = cursor.getInt(cursor.getColumnIndex(MyDBHelper.COL_ID));
            @SuppressLint("Range") String imageSrc = cursor.getString(cursor.getColumnIndex (MyDBHelper.COL_IMAGE));
            @SuppressLint("Range") String company = cursor.getString(cursor.getColumnIndex (MyDBHelper.COL_COMPANY));
            @SuppressLint("Range") String food = cursor.getString(cursor.getColumnIndex(MyDBHelper.COL_FOOD));
            @SuppressLint("Range") String price = cursor.getString(cursor.getColumnIndex (MyDBHelper.COL_PRICE));
            @SuppressLint("Range") String explanation = cursor.getString(cursor.getColumnIndex(MyDBHelper.COL_EX));

            list.add(new MyData(id, imageSrc, company, food, price, explanation));
        }

        cursor.close();
        dbHelper.close();

        return list;
    }
}
