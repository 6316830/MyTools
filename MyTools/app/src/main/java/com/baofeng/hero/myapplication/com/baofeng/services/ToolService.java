package com.baofeng.hero.myapplication.com.baofeng.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.baofeng.hero.myapplication.com.baofeng.dbHelper.DBManager;

/**
 * Created by bander_xie on 2015/9/10.
 */
public class ToolService extends Service {
    public   static final String TAG="MyService";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        DBManager dbManager=new DBManager(getApplicationContext());
        boolean exsit=dbManager.checkDBExist();
        if (exsit){
            Log.d(TAG,"==================db exist=======================");
        }else {
            Log.d(TAG,"==================db not exist=======================");
        }

        return super.onStartCommand(intent, flags, startId);
    }
}
