package com.myfittinglife.app.wanandroid.model;

import android.util.Log;

import com.myfittinglife.app.wanandroid.Api;
import com.myfittinglife.app.wanandroid.RequestAddress;
import com.myfittinglife.app.wanandroid.net.AddCookiesInterceptor;
import com.myfittinglife.app.wanandroid.net.UnCollectEssayLestener;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author      LD
 * @Time        2019/1/27 11:33
 * @Describe    取消收藏文章的Model
 * @Modify
 */
public class UnCollectEssayModel {

    private Api api;
    private UnCollectEssayLestener unCollectEssayLestener;

    private static final String TAG = "CollectEssayModel_ceshi";

    //读超时时长，单位：毫秒
    public static final int READ_TIME_OUT = 15 * 1000;
    //写超时时长，单位：毫秒
    public static final int WRITE_TIME_OUT = 15 * 1000;
    //连接超时时长，单位：毫秒
    public static final int CONNECT_TIME_OUT = 15 * 1000;

    public UnCollectEssayModel(UnCollectEssayLestener unCollectEssayLestener) {
        this.unCollectEssayLestener = unCollectEssayLestener;
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .addInterceptor(new AddCookiesInterceptor())
//                .addInterceptor(new ReceivedCookiesInterceptor())       //获取cookies存入本地
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RequestAddress.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())     //添加这个,对json数据解析
                .client(okHttpClient)
                .build();
        api = retrofit.create(Api.class);
    }

    /**
     * 取消收藏文章(站内文章，项目)
     */
    public void unCollectEssay(int id) {

        api.unCollectInSiteEssay(id).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response != null && response.body() != null) {

                    unCollectEssayLestener.unCollectEssaySuccess();
                } else {
                    Log.i(TAG, "onResponse: " + "请求成功，返回为空");
                    unCollectEssayLestener.unCollectEssayFailed();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                unCollectEssayLestener.unCollectEssayFailed();
            }
        });
    }

    /**
     * 取消收藏（我的收藏处取消）
     */
    public void unCollectMyEssay(int id,int originId){


        api.unCollectMyEssay(id,originId).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response != null && response.body() != null) {

                    unCollectEssayLestener.unCollectEssaySuccess();
                } else {
                    Log.i(TAG, "onResponse: " + "请求成功，返回为空");
                    unCollectEssayLestener.unCollectEssayFailed();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                unCollectEssayLestener.unCollectEssayFailed();
            }
        });
    }

}
