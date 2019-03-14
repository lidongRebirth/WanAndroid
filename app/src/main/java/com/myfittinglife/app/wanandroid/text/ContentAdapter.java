package com.myfittinglife.app.wanandroid.text;

import android.support.annotation.Nullable;
import android.support.design.internal.FlowLayout;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.myfittinglife.app.wanandroid.R;

import java.util.List;

/**
 * @Author
 * @Time        2019/1/29 20:22
 * @Describe    右侧布局添加数据
 * @Modify
 */
public class ContentAdapter extends BaseQuickAdapter<NavigationItem,BaseViewHolder> {


    public ContentAdapter(int layoutResId, @Nullable List<NavigationItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NavigationItem item) {
        helper.setText(R.id.tv_title, item.getName());
        FlowLayout flowLayout = helper.getView(R.id.layout_flow);
        flowLayout.removeAllViews();//*少这个会导致右侧重复的数据出现

        for(String s :item.getArticles()){

//            View child = View.inflate(mContext, R.layout.item_ceshi2, null);
            TextView textView = new TextView(mContext);
            textView.setText(s);

            flowLayout.addView(textView);
        }
    }
}
