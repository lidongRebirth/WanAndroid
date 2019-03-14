package com.myfittinglife.app.wanandroid;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * @Author      LD
 * @Time        2019/1/25 19:07
 * @Describe    application
 * @Modify
 */
public class App extends Application {

    private static App instance;

    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        refWatcher = LeakCanary.install(this);       //内存泄漏
    }

    public static synchronized App getInstance(){
        return instance;
    }


    public static RefWatcher getRefWatcher(Context context) {
        App application = (App) context.getApplicationContext();
        return application.refWatcher;
    }
}
