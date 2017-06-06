package com.cumt.game.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by hui on 2017/6/1.
 */

public class DataBaseHelper extends SQLiteOpenHelper{
    private static final  String DB_NAME="shop.db";
    private static final int DB_VERSION=1;

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.d("MainActivity","-------------DataBaseHelper");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d("MainActivity","-------------创建数据库");
        updataDataBase(sqLiteDatabase,0,DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        updataDataBase(sqLiteDatabase,oldVersion,newVersion);
    }

    public void updataDataBase(SQLiteDatabase db,int oldVersion,int newVersion){
        Log.d("MainActivity","oldVersion"+oldVersion);
        if(oldVersion<1){
            db.execSQL("CREATE TABLE shop(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "name VARCHAR(20),"
                    + "acctack INTEGER,"
                    + "life INTEGER,"
                    + "speed INTEGER)");
        }

    }
}
