package com.baofeng.hero.myapplication;

import android.app.Application;

//import com.baidu.mapapi.SDKInitializer;

/**
 * Created by bander_xie on 2015/9/8.
 */
public class MyToolApplication extends Application {
    public MyToolApplication() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
     //   SDKInitializer.initialize(this);
    }


}
