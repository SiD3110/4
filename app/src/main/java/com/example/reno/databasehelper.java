package com.example.reno;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databasehelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Manager.db";
    public static final String TABLE_NAME="Manage.db";
    public static final String COL_1="id";
    public static final String COL_5="enrollment";
    public static final String COL_3="password";
    public static final String COL_4="email";
    public static final String COL_2="name";

    public databasehelper(Context context) {
        super(context, DATABASE_NAME, null, 1);


    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("create table"+TABLE_NAME+("id INTEGER PRIMARY KEY  AUTOINCREMENT,name TEXT,enrollment VARCHAR,password INTEGER,email VARCHAR");

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i,int i1)
    {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}

