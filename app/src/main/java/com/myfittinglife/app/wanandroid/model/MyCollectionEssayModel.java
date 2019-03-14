package com.myfittinglife.app.wanandroid.model;

import android.util.Log;

import com.myfittinglife.app.wanandroid.Api;
import com.myfittinglife.app.wanandroid.RequestAddress;
import com.myfittinglife.app.wanandroid.bean.MyCollectionBean2;
import com.myfittinglife.app.wanandroid.net.GetCollectEssayListener;
import com.myfittinglife.app.wanandroid.utils.CookiesUtil;

import java.io.IOException;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author      LD
 * @Time        2019/1/27 17:01
 * @Describe    我的收藏Model
 * @Modify
 */
public class MyCollectionEssayModel {

    private Api api;
    Retrofit retrofit;
    private static final String TAG = "ceshi127";
    private GetCollectEssayListener getCollectEssayListener;


    public MyCollectionEssayModel(GetCollectEssayListener getCollectEssayListener) {

        this.getCollectEssayListener = getCollectEssayListener;

        retrofit = new Retrofit.Builder()
                .baseUrl(RequestAddress.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())     //添加这个,对json数据解析
                .client(CookiesUtil.getOkHttpClient())
                .build();
        api = retrofit.create(Api.class);

    }

    /**
     * 获取我的收藏的文章列表
     */
    public void getMyCollectedEssay(){
        
        api.getMyCollection(0).enqueue(new Callback<MyCollectionBean2>() {
            @Override
            public void onResponse(Call<MyCollectionBean2> call, Response<MyCollectionBean2> response) {

                if(response!=null&&response.body()!=null){
                    getCollectEssayListener.onGetCollectEssaySuccess(response.body());
                }else {
                    Log.i(TAG, "onResponse: "+"请求成功，返回为空");
                    getCollectEssayListener.onGetCollectEssayFailed("数据为空");
                }
            }

            @Override
            public void onFailure(Call<MyCollectionBean2> call, Throwable t) {
                Log.i(TAG, "onResponse: "+"请求失败");
                getCollectEssayListener.onGetCollectEssayFailed("请求失败");

            }
        });



    }

}
