package com.myfittinglife.app.wanandroid.model;

import android.util.Log;

import com.myfittinglife.app.wanandroid.Api;
import com.myfittinglife.app.wanandroid.RequestAddress;
import com.myfittinglife.app.wanandroid.bean.UserBean;
import com.myfittinglife.app.wanandroid.bean.ProjectClassifyBean;
import com.myfittinglife.app.wanandroid.bean.ProjectListBean;
import com.myfittinglife.app.wanandroid.bean.RegisterBean;
import com.myfittinglife.app.wanandroid.net.AddCookiesInterceptor;
import com.myfittinglife.app.wanandroid.net.OnNetFinishListener;
import com.myfittinglife.app.wanandroid.net.ReceivedCookiesInterceptor;
import com.myfittinglife.app.wanandroid.utils.CookiesUtil;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author      LD
 * @Time        2019/1/21 17:33
 * @Describe    数据处理Model集合
 * @Modify
 */
public class CommentRequestModel {

    private Api api;
    private static final String TAG = "Model1";
    private OnNetFinishListener onNetFinishListener;

    //读超时时长，单位：毫秒
    public static final int READ_TIME_OUT = 15 * 1000;
    //写超时时长，单位：毫秒
    public static final int WRITE_TIME_OUT = 15 * 1000;
    //连接超时时长，单位：毫秒
    public static final int CONNECT_TIME_OUT = 15 * 1000;


    /**
     * 构造函数
     * @param onNetFinishListener       网络请求回调监听器
     */
    public CommentRequestModel(OnNetFinishListener onNetFinishListener) {

//        HttpLoggingInterceptor logging =new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);


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
        this.onNetFinishListener = onNetFinishListener;
    }


    /**
     * 注册方法
     * @param username      账号
     * @param password      密码
     * @param rePassword    确认密码
     */
    public void register(String username, String password, final String rePassword){

        HashMap<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        params.put("repassword", rePassword);


        api.registerAccount(params).enqueue(new Callback<RegisterBean>() {
            @Override
            public void onResponse(Call<RegisterBean> call, Response<RegisterBean> response) {
                if(response!=null&&response.body()!=null){
                    //0注册成功-1及其他注册失败
                    if(response.body().getErrorCode()==0){
                        onNetFinishListener.onRequestSuccess("注册成功");
                    }else {
                        onNetFinishListener.onRequestFailed(response.body().getErrorMsg());
                    }
                }else{

                    Log.i(TAG, "onResponse: "+"请求成功但为空");
                }
            }

            @Override
            public void onFailure(Call<RegisterBean> call, Throwable t) {
                Log.i(TAG, "onFailure: "+"发生错误");
                onNetFinishListener.onRequestFailed(""+t);
            }
        });
    }


    /**
     * 登录方法
     * @param username      账号
     * @param password      密码
     */
    public void login(String username,String password){

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
//                .addInterceptor(new AddCookiesInterceptor())
                .addInterceptor(new ReceivedCookiesInterceptor())
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RequestAddress.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())     //添加这个,对json数据解析
                .client(okHttpClient)
                .build();
        api = retrofit.create(Api.class);



        HashMap<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        api.login(params).enqueue(new Callback<UserBean>() {
            @Override
            public void onResponse(Call<UserBean> call, Response<UserBean> response) {
                if(response!=null&&response.body()!=null){
                    //0登录成功-1及其他登录失败
                    if(response.body().getErrorCode()==0){

                        onNetFinishListener.onRequestSuccess("登录成功");

                        List<UserBean> loginBeans = new ArrayList<>();                           //也可以这样写，将其转为集合传
                        loginBeans.add(response.body());
                        onNetFinishListener.onRequestSuccess(loginBeans);                     //登录成功后调用这个将用户信息传过去并存储在SharePreference中


                    }else {
                        onNetFinishListener.onRequestFailed(response.body().getErrorMsg());
                    }
                }else{
                    Log.i(TAG, "onResponse: "+"请求成功但为空");
                }
            }
            @Override
            public void onFailure(Call<UserBean> call, Throwable t) {
                Log.i(TAG, "onFailure: "+"发生错误");
                onNetFinishListener.onRequestFailed(""+t);
            }
        });

    }

    /**
     * 请求项目分类 名称
     */
    public void getProjectClassify(){

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(RequestAddress.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())     //添加这个,对json数据解析
//                .client(CookiesUtil.getOkHttpClient())
//                .build();
//        Api api = retrofit.create(Api.class);
        api.getProjectClassify().enqueue(new Callback<ProjectClassifyBean>() {
            @Override
            public void onResponse(Call<ProjectClassifyBean> call, Response<ProjectClassifyBean> response) {
                if (response != null && response.body() != null) {      //因为不知道该接口errorCode相对应的信息，所以未做此判断
                    onNetFinishListener.onRequestSuccess(response.body().getData());
                } else {
                    Log.i(TAG, "onResponse: "+"请求成功但为空");
                }
            }

            @Override
            public void onFailure(Call<ProjectClassifyBean> call, Throwable t) {
                Log.i(TAG, "onFailure: "+"发生错误");
                onNetFinishListener.onRequestFailed(""+t);

            }
        });
    }

    /**
     * 请求项目列表
     */
    public void getProjectList(int page,int cid){

                Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RequestAddress.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())     //添加这个,对json数据解析
                .client(CookiesUtil.getOkHttpClient())
                .build();
        Api api = retrofit.create(Api.class);


        api.getProjectList(page,cid).enqueue(new Callback<ProjectListBean>() {
            @Override
            public void onResponse(Call<ProjectListBean> call, Response<ProjectListBean> response) {
                if(response!=null&&response.body()!=null){

                    onNetFinishListener.onRequestSuccess(response.body().getData().getDatas());
                }else {
                    Log.i(TAG, "onResponse: "+"请求成功，返回为空");
                }
            }

            @Override
            public void onFailure(Call<ProjectListBean> call, Throwable t) {
                Log.i(TAG, "onFailure: 请求失败"+t);
            }
        });
    }









    //----------------------------------------------------------------------------------------------
    /**
     * 通用的get方法，来测试数据用（未使用）
     * @param url   baseUrl后拼接的数据
     * @param map
     */
    public void getCommentData(String url, Map map){
        api.getCommentData(url,map).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });


    }

}
