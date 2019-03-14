package com.myfittinglife.app.wanandroid.text;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.myfittinglife.app.wanandroid.R;

import java.util.List;

/**
 * @Author
 * @Time 2019/1/29 20:02
 * @Describe
 * @Modify
 */
public class NavigationAdapter extends BaseQuickAdapter<NavigationItem,BaseViewHolder> {


    public NavigationAdapter(int layoutResId, List<NavigationItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NavigationItem item) {

        helper.setText(R.id.tv_navigation, item.getName());
        helper.getView(R.id.tv_navigation).setSelected(item.isSelected());

    }
}
