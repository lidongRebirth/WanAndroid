package com.myfittinglife.app.wanandroid.net;

import java.util.List;

/**
 * @Author      LD
 * @Time        2019/1/21 18:23
 * @Describe    通过泛型来做网络请求的回调接口，使得各个网络请求均可用
 * @Modify
 */
public interface OnNetFinishListener<E> {

    /**
     * 网络请求失败
     * @param str   错误信息
     */
    void onRequestFailed(String str);

    /**
     * 网络请求成功，列表的返回
     * @param list  获取到的列表
     */
    void onRequestSuccess(List<E> list);

    /**
     * 网络请求成功，字符串的返回（也可以不写此方法，）
     * @param string
     */
    void onRequestSuccess(String string);

}
