package ddwucom.mobile.example.test15;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class FoodDBManager {
    FoodDBHelper helper = null;
    Cursor cursor;

    public FoodDBManager(Context context){
       helper = new FoodDBHelper(context);
    }

    public ArrayList<Food> getAllFood(){
        ArrayList<Food> list = new ArrayList<Food>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + FoodDBHelper.TABLE_NAME, null);

        while(cursor.moveToNext()){
            long _id = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_ID));
            String food = cursor.getString(1);
            String nation = cursor.getString(2);

            list.add(new Food(_id, food, nation));
        }

        cursor.close();
        helper.close();

        return list;
    }

    public boolean addNewFood(Food newFood){
        SQLiteDatabase db = helper.getWritableDatabase ();
        ContentValues row = new ContentValues();
        row.put("food", newFood.getFood());
        row.put("nation", newFood.getNation());

        long result = db.insert(FoodDBHelper.TABLE_NAME, null, row);
        helper.close();

        if(result>0)
            return true;
        return false;
    }

    //    _id 를 기준으로 food 의 이름과 nation 변경
    public boolean modifyFood(Food food){
        SQLiteDatabase db = helper.getWritableDatabase ();
        ContentValues row = new ContentValues();
        row.put("food", food.getFood());
        row.put("nation", food.getNation());

        String where = "_id=?";
        String[] args = new String[]{String.valueOf(food.get_id())};
        int result = db.update(FoodDBHelper.TABLE_NAME, row, where, args);
        helper.close();

        if(result>0)
            return true;
        return false;
    }

    public boolean removeFood(long id){
        SQLiteDatabase db = helper.getWritableDatabase ();
        String whereClause = "_id=?";
        String[] args = new String[]{String.valueOf(id)};

        int result = db.delete(FoodDBHelper.TABLE_NAME, whereClause, args);
        helper.close();

        if(result>0)
            return true;
        return false;
    }
}
