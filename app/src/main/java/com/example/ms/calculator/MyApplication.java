package com.example.ms.calculator;

import android.app.Application;
import android.content.Context;

/**
 * 获取全局context
 * Created by MS on 2017/9/12.
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate(){
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
