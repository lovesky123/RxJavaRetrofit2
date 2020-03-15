package com.xulc.kitdemo.base;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
public class App extends Application {
    @SuppressLint("StaticFieldLeak")
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
//      CrashReport.initCrashReport(getApplicationContext(), "7c22ff2be7", false);
    }

    public static Context getAppContext() {
        return context;
    }
}
