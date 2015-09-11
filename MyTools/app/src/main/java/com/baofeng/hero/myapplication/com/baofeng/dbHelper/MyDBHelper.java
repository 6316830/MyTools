package com.baofeng.hero.myapplication.com.baofeng.dbHelper;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

/**
 * Created by bander_xie on 2015/9/10.
 */
public class MyDBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "mytooldb.db"; //保存的数据库文件名
    public static final String PACKAGE_NAME = "com.baofeng.hero.myapplication";
    public static final String DB_PATH = "/data"
            + Environment.getDataDirectory().getAbsolutePath() + "/"
            + PACKAGE_NAME;  //在手机里存放数据库的位置(/data/data/com.baofeng.hero.myapplication/mytooldb.db)
    private SQLiteDatabase database;
    @Override
    public void onCreate(SQLiteDatabase db) {
       //  db = SQLiteDatabase.openOrCreateDatabase(DB_PATH, null);
    }

    @Override
    public SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
