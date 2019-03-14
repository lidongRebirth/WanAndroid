package com.myfittinglife.app.wanandroid.utils;

import com.myfittinglife.app.wanandroid.net.AddCookiesInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * @Author      LD
 * @Time        2019/1/27 16:30
 * @Describe    cookies管理(目前没用到，不管用)
 * @Modify
 */
public class CookiesUtil {

    //读超时时长，单位：毫秒
    public static final int READ_TIME_OUT = 15 * 1000;
    //写超时时长，单位：毫秒
    public static final int WRITE_TIME_OUT = 15 * 1000;
    //连接超时时长，单位：毫秒
    public static final int CONNECT_TIME_OUT = 15 * 1000;

    public static OkHttpClient getOkHttpClient() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .addInterceptor(new AddCookiesInterceptor())
//                .addInterceptor(new ReceivedCookiesInterceptor())       //获取cookies存入本地
                .build();
        return okHttpClient;
    }
}
