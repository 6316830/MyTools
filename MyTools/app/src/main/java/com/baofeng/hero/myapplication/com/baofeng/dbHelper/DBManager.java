package com.baofeng.hero.myapplication.com.baofeng.dbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import com.baofeng.hero.myapplication.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by bander_xie on 2015/9/10.
 */
public class DBManager {
    private final int BUFFER_SIZE = 400000;
    public static final String DB_NAME = "mytooldb.db"; //保存的数据库文件名
    public static final String PACKAGE_NAME = "com.baofeng.hero.myapplication";
    public static final String DB_PATH = "/data"
            + Environment.getDataDirectory().getAbsolutePath() + "/"
            + PACKAGE_NAME;  //在手机里存放数据库的位置(/data/data/com.baofeng.hero.myapplication/mytooldb.db)
    private SQLiteDatabase database;
    private Context context;

    public DBManager(Context context) {
        this.context = context;
    }
    public boolean checkDBExist(){
       // database=openDatabase(DB_PATH);
        if (openDatabase(DB_PATH)) {
            return true; }
        return false;
    }
    private boolean openDatabase(String dbfile) {
        try {
            if (!(new File(dbfile).exists())) {
                //判断数据库文件是否存在，若不存在则执行导入，否则直接打开数据库
                InputStream is = this.context.getResources().openRawResource(
                        R.raw.mytooldb); //欲导入的数据库
                FileOutputStream fos = new FileOutputStream(dbfile);
                byte[] buffer = new byte[BUFFER_SIZE];
                int count = 0;
                while ((count = is.read(buffer)) > 0) {
                    fos.write(buffer, 0, count);
                }
                fos.close();
                is.close();
            }

          //  SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dbfile, null);
            return true;

        } catch (FileNotFoundException e) {
            Log.e("Database", "File not found");
            e.printStackTrace();
        } catch (IOException e) {
            Log.e("Database", "IO exception");
            e.printStackTrace();
        }
        return false;
    }
}
