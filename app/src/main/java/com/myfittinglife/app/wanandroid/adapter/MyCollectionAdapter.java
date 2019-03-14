package com.myfittinglife.app.wanandroid.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.myfittinglife.app.wanandroid.R;
import com.myfittinglife.app.wanandroid.bean.MyCollectionBean;
import com.myfittinglife.app.wanandroid.utils.ImageUtil;

import java.util.List;

/**
 * @Author      LD
 * @Time        2019/1/27 17:43
 * @Describe    我的收藏适配器
 * @Modify
 */
public class MyCollectionAdapter extends BaseMultiItemQuickAdapter<MyCollectionBean, BaseViewHolder> {


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MyCollectionAdapter(List<MyCollectionBean> data) {

        super(data);
        addItemType(MyCollectionBean.INSITEESSAY, R.layout.item_insite_collection);
        addItemType(MyCollectionBean.OUTSITEESSAY, R.layout.item_outsite_collection);

    }

    @Override
    protected void convert(BaseViewHolder helper, MyCollectionBean item) {
        switch (helper.getItemViewType()) {
            case MyCollectionBean.INSITEESSAY:      //站内文章
                helper.setText(R.id.tv_author, item.getMyCollectionBean().getAuthor());
                helper.setText(R.id.tv_collectTime, item.getMyCollectionBean().getNiceDate());
                helper.setText(R.id.tv_title, item.getMyCollectionBean().getTitle());
                helper.setText(R.id.tv_classify, item.getMyCollectionBean().getChapterName());
                //收藏
                helper.setImageResource(R.id.iv_collect, R.drawable.ic_collected);
                //加载封面图(站内比站外多了封面图)
                ImageUtil.loadStaticImage(mContext,item.getMyCollectionBean().getEnvelopePic(), (ImageView) helper.getView(R.id.iv_envelope));

                helper.addOnClickListener(R.id.iv_collect);     //收藏的点击事件

                break;
            case MyCollectionBean.OUTSITEESSAY:     //站外文章
                helper.setText(R.id.tv_author, item.getMyCollectionBean().getAuthor());
                helper.setText(R.id.tv_collectTime, item.getMyCollectionBean().getNiceDate());
                helper.setText(R.id.tv_title, item.getMyCollectionBean().getTitle());
                helper.setText(R.id.tv_classify, item.getMyCollectionBean().getChapterName());
                //收藏
                helper.setImageResource(R.id.iv_collect, R.drawable.ic_collected);

                helper.addOnClickListener(R.id.iv_collect);     //收藏的点击事件

                break;
            default:
                break;
        }
    }
}
