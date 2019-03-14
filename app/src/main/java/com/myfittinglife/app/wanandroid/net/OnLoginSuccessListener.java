package com.myfittinglife.app.wanandroid.net;

import com.myfittinglife.app.wanandroid.bean.UserBean;

/**
 * @Author      LD
 * @Time        2019/1/26 18:45
 * @Describe    登录成功后回调，主要用来刷新slideFragment中的用户信息
 * @Modify
 */
public interface OnLoginSuccessListener {

    /**
     * 登录成功后回调，主要用来刷新slideFragment中的用户信息
     */
    void onLoginSuccess(UserBean userBean);
}
