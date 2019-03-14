package com.myfittinglife.app.wanandroid.net;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.myfittinglife.app.wanandroid.App;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * @Author
 * @Time        2019/1/24 20:36
 * @Describe    获取cookies并存储在本地
 * @Modify
 */
public class ReceivedCookiesInterceptor implements Interceptor {

    private static final String TAG = "ReceivedCookies_ceshi";

    public ReceivedCookiesInterceptor() {
        super();

    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Response originalResponse = chain.proceed(chain.request());

        //这里获取请求返回的cookie
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {

            //*1.25--------------------------获取cookies---------------------------------------------
            HashSet<String> cookies = new HashSet<>();
            for(String header: originalResponse.headers("Set-Cookie"))
            {
                Log.i(TAG, "拦截的cookie是："+header);
                cookies.add(header);
            }

            Log.i("ceshi", "intercept: "+ originalResponse.headers().toString());
//            Log.i("ceshi", "intercept: "+ originalResponse.headers("Set-Cookie").toString());



//            SharedPreferences sharedPreferences = context.getSharedPreferences("cookieData", Context.MODE_PRIVATE);//保存的sharepreference文件名为cookieData
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putStringSet("cookie", cookies);

            SharedPreferences sharedPreferences = App.getInstance().getSharedPreferences("cookieData", Context.MODE_PRIVATE);//保存的sharepreference文件名为cookieData
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putStringSet("cookie", cookies);

            editor.commit();
        }

        return originalResponse;
    }
}
