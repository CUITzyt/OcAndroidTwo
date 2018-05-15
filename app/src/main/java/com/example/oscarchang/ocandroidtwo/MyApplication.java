package com.example.oscarchang.ocandroidtwo;

import android.app.Application;

import com.example.oscarchang.ocandroidtwo.util.MyLog;

/**
 * Created by SDT13976 on 2018/5/15.
 */
public class MyApplication extends Application {

    private static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        MyLog.setTAG("OscarChang");
    }

    public static MyApplication getInstance(){
        return mInstance;
    }
}
