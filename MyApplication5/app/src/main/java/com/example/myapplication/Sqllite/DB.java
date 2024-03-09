package com.example.databaseoperation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqliteDB extends SQLiteOpenHelper {

    public SqliteDB(@Nullable Context context) {
        super(context, "shivamskdb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table shivtblsk (id integer primary key autoincrement,name varchar(50),city varchar(50));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Cursor getshivtbl(){
        SQLiteDatabase db=getReadableDatabase();
        return db.rawQuery("select * from shivtblsk",null);
    }
    public void addrecord(String name,String city){
        SQLiteDatabase db=getReadableDatabase();
        db.execSQL("insert into shivtblsk(name,city) values('"+name+"','"+city+"')");

    }

    public void updaterecord(int id,String name,String city){
        SQLiteDatabase db=getReadableDatabase();
        db.execSQL("update shivtblsk set name='"+name+"',city='"+city+"' where id="+id);

    }

    public void delrecord(int id){
        SQLiteDatabase db=getReadableDatabase();
        db.execSQL("delete from shivtblsk where id="+id);
    }

}

