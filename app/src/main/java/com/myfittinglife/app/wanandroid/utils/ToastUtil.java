package com.myfittinglife.app.wanandroid.utils;

import android.content.Context;
import android.widget.Toast;

import javax.xml.validation.TypeInfoProvider;

/**
 * @Author      LD
 * @Time        2019/1/24 15:00
 * @Describe    Toast工具类（未完成，日后解决兼容性问题,并加入自定View）
 * @Modify
 */
public class ToastUtil {

    /**
     * 普通的短显示
     * @param context
     * @param content
     */
    public static void showToast(Context context, String content){

        showToast(context,content,Toast.LENGTH_SHORT);
    }

    /**
     * 普通的长时间显示
     * @param context
     * @param content
     * @param time
     */
    public static void showToast(Context context,String content,int time){

        Toast.makeText(context,content, time).show();


    }



}
