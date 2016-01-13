package com.xinyi.duan.drugstore;

import android.app.Application;
import android.content.Context;

/**
 * Created by Duan on 2016/1/13.
 */
public class MyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
