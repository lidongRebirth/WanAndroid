package com.myfittinglife.app.wanandroid.utils;

/**
 * @Author      LD
 * @Time        2019/1/27 11:56
 * @Describe    时间工具类
 * @Modify
 */
public class TimeUtil {

    public final static int CLICK_TIME = 500;
    public static  long lastClickTime;

    /**
     * 验证上次点击按钮时间间隔，防止重复点击
     * @return
     */
    public synchronized  static boolean isFastClick() {

        long time = System.currentTimeMillis();
        if ( time - lastClickTime < CLICK_TIME) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

}
