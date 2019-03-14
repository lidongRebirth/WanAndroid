package com.myfittinglife.app.wanandroid.net;

import com.myfittinglife.app.wanandroid.bean.MyCollectionBean2;

import java.util.List;

/**
 * @Author      LD
 * @Time        2019/1/28 18:12
 * @Describe    获取收藏列表的监听器
 * @Modify
 */
public interface GetCollectEssayListener {

    void onGetCollectEssaySuccess(MyCollectionBean2 myCollectionBean2);


    void onGetCollectEssayFailed(String str);
}
