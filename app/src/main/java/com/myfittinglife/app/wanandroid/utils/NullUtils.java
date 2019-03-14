package com.myfittinglife.app.wanandroid.utils;

import android.widget.TextView;

import java.util.List;

/**
*  @Author      LD
*  @Time        2019.1.25
*  @Describe    各种空判断
*  @Modify
*/

public class NullUtils {

    public static boolean isStringEmpty(String str){
        return str==null||"".equals(str)||"null".equalsIgnoreCase(str);
    }

    public static boolean isTextEmpty(TextView textView) {
        return isStringEmpty(textView.getText().toString().trim());
    }

    public static boolean isListEmpty(List list){
        return list==null||list.size()<=0;
    }
}
