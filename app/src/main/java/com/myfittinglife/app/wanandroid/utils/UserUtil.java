package com.myfittinglife.app.wanandroid.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.gson.Gson;
import com.myfittinglife.app.wanandroid.App;
import com.myfittinglife.app.wanandroid.bean.UserBean;

/**
 * @Author LD
 * @Time 2019/1/24 16:36
 * @Describe 用户管理类, 用来判断用户是否登录，获取用户信息等操作
 * @Modify
 */
public class UserUtil {


    //SharePreferences文件名
    public static final String USERSPNAME = "usersharepreference";
    //保存的键名
    public static final String USER = "usersp";

    /**
     * 存储用户信息
     */
    public static void setUserBean(UserBean userBean) {
        if (userBean != null) {
            SharedPreferences sharedPreferences = App.getInstance().getSharedPreferences(USERSPNAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            editor.putString(USER, gson.toJson(userBean));
            editor.commit();
        }
    }

    /**
     * 获取用户信息
     */
    public static UserBean getUserBean() {

        SharedPreferences sp = App.getInstance().getSharedPreferences(USERSPNAME, Context.MODE_PRIVATE);
        String userinfo = sp.getString(USER, "");
        if (StringUtil.isEmpty(userinfo)) {
            return null;
        } else {
            Gson gson = new Gson();
            UserBean userBean = gson.fromJson(userinfo, UserBean.class);
            return userBean;
        }
    }

    /**
     * 删除Cookies和用户的SharePreference(更新用户信息和各个界面请求的信息)还未成功
     */
    public static void deleteCookies() {
        SharedPreferences userbeanSP = App.getInstance().getSharedPreferences(USERSPNAME, Context.MODE_PRIVATE);
        if (userbeanSP != null) {
            userbeanSP.edit().clear().commit();
        }


        SharedPreferences cookiesSP = App.getInstance().getSharedPreferences("cookieData", Context.MODE_PRIVATE);
        if (cookiesSP != null) {
            cookiesSP.edit().clear().commit();
        }
    }


}
