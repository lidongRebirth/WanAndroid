package com.myfittinglife.app.wanandroid.adapter;


import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.myfittinglife.app.wanandroid.R;
import com.myfittinglife.app.wanandroid.bean.ProjectListBean;
import com.myfittinglife.app.wanandroid.utils.ImageUtil;

import java.util.List;

/**
 * @Author      LD
 * @Time        2019/1/22 19:48
 * @Describe    tabfragment的适配器(项目)
 * @Modify
 */
public class TabFragmentAdapter extends BaseQuickAdapter<ProjectListBean.DataBean.DatasBean,BaseViewHolder>{

    private List<ProjectListBean.DataBean.DatasBean> projectListBeans;

    public TabFragmentAdapter(int layoutResId, List<ProjectListBean.DataBean.DatasBean> data) {
        super(layoutResId, data);
        this.projectListBeans = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, ProjectListBean.DataBean.DatasBean item) {
        helper.setText(R.id.tv_title, item.getTitle());
        helper.setText(R.id.tv_publishTime, String.valueOf(item.getNiceDate()));
        helper.setText(R.id.tv_author, item.getAuthor());
//        Glide.with(mContext).load(item.getEnvelopePic()).into((ImageView) helper.getView(R.id.iv_envelope));
        ImageUtil.loadStaticImage(mContext,item.getEnvelopePic(), (ImageView) helper.getView(R.id.iv_envelope));
        //收藏点击事件
        helper.addOnClickListener(R.id.iv_collect);
        helper.setImageResource(R.id.iv_collect, item.isCollect() ? R.drawable.ic_collected: R.drawable.ic_no_collect);

    }



}
