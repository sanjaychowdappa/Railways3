package com.example.sanjay.railways3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Sanjay on 25-02-2018.
 */
public class Database extends SQLiteOpenHelper {
    String email;
private static final int Databade_version=1;
    private static final String Database_name="data.db";
    private static final String Database_table="details";
    private static final String coloum_id ="id";
    private static final String coloum_name="name";
    private static final String coloum_email="email";
    private static final String coloum_age="age";
    private static final String coloum_pass="password";
    private static final String coloum_uname="username";
    private static final String coloum_mobile="mobile";

    SQLiteDatabase db ;
    private static final String table_create="create table Details(id integer primary key not null,name text not null,email text not null," +
            "age int not null,password text not null,username text not null,mobile text not null);";

    public Database(Context context) {
        super(context, Database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL(table_create);
        this.db=db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
String query="DROP TABLE IF EXISTS "+Database_table;
        db.execSQL(query,null);
        this.onCreate(db);
    }
    public void  insertValues(information in){
     db=this.getWritableDatabase();
      String query="select * from "+Database_table;
        Cursor cursor=db.rawQuery(query,null);
        int count=cursor.getCount();
        ContentValues contentValues=new ContentValues();
        contentValues.put(coloum_id,count);
        contentValues.put(coloum_mobile,in.getMobile());
        contentValues.put(coloum_name,in.getName());
        contentValues.put(coloum_email,in.getEmail());
        contentValues.put(coloum_age,in.getAge());
        contentValues.put(coloum_pass,in.getPass());
        contentValues.put(coloum_uname,in.getUname());
        db.insert(Database_table,null,contentValues);
db.close();
    }
    public String search(String uname){
        db=this.getReadableDatabase();
        String query="select username,password from "+Database_table;
        Cursor cursor=db.rawQuery(query,null);
        String a,b="not found";
        if(cursor.moveToFirst()){
            do{
                a=cursor.getString(0);
                if(a.equals(uname)) {
                    b=cursor.getString(1);
                    break;
                }

            }
            while (cursor.moveToNext());


        }

return  b;

    }
    public Cursor profile(String uname){
        db=this.getReadableDatabase();
        String query="select * from "+Database_table;
        Cursor cursor=db.rawQuery(query,null);
        ContentValues contentValues=new ContentValues();
        String a,b="not found";
        if(cursor.moveToFirst()){
            do{
                a=cursor.getString(2);
                if(a.equals(uname)) {
                    break;
                }

            }
            while (cursor.moveToNext());


        }
        return  cursor;
    }
}
