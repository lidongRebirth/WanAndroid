package com.myfittinglife.app.wanandroid.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;


/**
 * @Author      LD
 * @Time        2019/1/28 16:00
 * @Describe    收藏的站外文章chaperID为0，其余的不知道，将收藏的文章重新整理，为了实现多布局
 * @Modify
 */
public class MyCollectionBean implements MultiItemEntity {

    public static final int INSITEESSAY = 1;
    public static final int OUTSITEESSAY= 2;

    private int itemType;                       //用来区分类别

    public MyCollectionBean2.DataBean.DatasBean getMyCollectionBean() {
        return myCollectionBean;
    }

    private MyCollectionBean2.DataBean.DatasBean myCollectionBean;


    public MyCollectionBean(int itemType ,MyCollectionBean2.DataBean.DatasBean myCollectionBean) {
        this.itemType = itemType;
        this.myCollectionBean = myCollectionBean;
    }

    @Override
    public int getItemType() {
        return itemType;
    }





}
