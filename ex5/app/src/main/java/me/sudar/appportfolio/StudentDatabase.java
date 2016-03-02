package me.sudar.appportfolio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sel-65 on 2/3/16.
 */
public class StudentDatabase extends SQLiteOpenHelper {

    private static final String DB_NAME = "student_database";
    private static final String TABLE_NAME = "student_table";
    private static final String STUDENT_NAME = "student_name";
    private static final String STUDENT_GENDER = "student_gender";
    private static final String STUDENT_DEPT = "student_dept";
    private static final String STUDENT_PHONE = "student_phone";

    public StudentDatabase(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table " + TABLE_NAME + "(" +
                        STUDENT_NAME + "text ," +
                        STUDENT_GENDER + "text ," +
                        STUDENT_DEPT + "text ," +
                        STUDENT_PHONE + "integer primary key;"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);
    }

    public void insertData(String name,String gender, String dept,Integer phone){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(STUDENT_NAME,name);
        contentValues.put(STUDENT_GENDER,gender);
        contentValues.put(STUDENT_DEPT,dept);
        contentValues.put(STUDENT_PHONE, phone);

        db.insert(TABLE_NAME, null, contentValues);
    }

    public Cursor getData(int phone){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from " + TABLE_NAME + "where " + STUDENT_PHONE + " = " + phone + "", null);
    }

    public void updateData(String name,String gender, String dept,Integer phone){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(STUDENT_NAME,name);
        contentValues.put(STUDENT_GENDER,gender);
        contentValues.put(STUDENT_DEPT,dept);
        contentValues.put(STUDENT_PHONE,phone);

        db.update(TABLE_NAME, contentValues, STUDENT_PHONE + " = ?", new String[] {Integer.toString(phone)});
    }

    public void deleteData(int phone){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, STUDENT_PHONE + " = ?", new String[] {Integer.toString(phone)});
    }
}
