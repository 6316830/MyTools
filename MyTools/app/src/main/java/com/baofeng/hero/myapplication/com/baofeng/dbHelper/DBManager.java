package com.baofeng.hero.myapplication.com.baofeng.dbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import com.baofeng.hero.myapplication.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public static final  String COLUMN_ID="id";
    public static final  String COLUMN_DATE="date";
    public static final  String COLUMN_CONTENT="content";

    private SQLiteDatabase database;
    private Context context;
    MyDBHelper dbHelper;

    public DBManager(Context context) {
        this.context = context;
        dbHelper=new MyDBHelper(context,"mytooldb",null,1);
      //  database=dbHelper.getReadableDatabase();

    }
    public boolean checkDBExist(){
       // database=openDatabase(DB_PATH);
        String temp1=DB_PATH+"/"+DB_NAME;
        if (openDatabase(temp1)) {
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

           // SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dbfile, null);

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


    public  String  readDB(String string){
        String temp1=DB_PATH+"/"+DB_NAME;
        database=SQLiteDatabase.openOrCreateDatabase(temp1,null);
        String sql="Select content From mynote where id = 1 ";
        Cursor cursor=database.rawQuery(string,null);
        cursor.moveToFirst();
        String result= cursor.getString(0);

        return result;

    }
    public  List  selectAll(){
        String temp1=DB_PATH+"/"+DB_NAME;
        database=SQLiteDatabase.openOrCreateDatabase(temp1,null);
        String sql="SELECT * FROM mynote";
     //   database.execSQL("INSERT INTO mynote (id,date,content) VALUES (2,'2015-7-8','ssdsad')");
       Cursor cursor=database.rawQuery(sql,null);
        cursor.moveToFirst();
        List<Map<String,String>> lists=new ArrayList<>();
        while (!cursor.isAfterLast()){
            Map<String,String>  day=new HashMap<>();
            int id=cursor.getInt(0);
            String time=cursor.getString(1);
            String content=cursor.getString(2);
            day.clear();
            day.put("id", String.valueOf(id));
            day.put("time", time);
            day.put("content", content);
            lists.add(day);
            cursor.moveToNext();
        }
        return lists;
    }

    public  void  insertDay(String _date,String _content){
        String temp1=DB_PATH+"/"+DB_NAME;
        String sql="INSERT INTO mynote (id,date,content) VALUES (?,?,?)";
        database=SQLiteDatabase.openOrCreateDatabase(temp1,null);
       // database.execSQL("INSERT INTO mynote (id,date,content) VALUES (2,'2015-7-8','ssdsad')");
        ContentValues contentValues=new ContentValues(3);
        contentValues.put(COLUMN_ID,"");
        contentValues.put(COLUMN_DATE,_date);
        contentValues.put(COLUMN_CONTENT,_content);
        database.insert("mynote",COLUMN_ID,contentValues);
    }
}
