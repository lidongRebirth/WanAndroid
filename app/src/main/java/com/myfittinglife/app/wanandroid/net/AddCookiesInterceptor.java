package com.myfittinglife.app.wanandroid.net;

import android.content.Context;
import android.util.Log;

import com.myfittinglife.app.wanandroid.App;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Author          LD
 * @Time            2019/1/25 10:00
 * @Describe        添加Cookiess
 * @Modify
 */
public class AddCookiesInterceptor implements Interceptor {

    public AddCookiesInterceptor() {
        super();

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        HashSet<String> preferences = (HashSet) App.getInstance().getSharedPreferences("cookieData",
                Context.MODE_PRIVATE).getStringSet("cookie", null);
        if (preferences != null) {
            for (String cookie : preferences) {
                builder.addHeader("Cookie", cookie);
                Log.v("OkHttp", "Adding Header: " + cookie); // This is done so I know which headers are being added; this interceptor is used after the normal logging of OkHttp
            }
        }
        return chain.proceed(builder.build());
    }
}
