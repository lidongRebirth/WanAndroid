package com.myfittinglife.app.wanandroid.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.myfittinglife.app.wanandroid.R;
import com.myfittinglife.app.wanandroid.adapter.MyCollectionAdapter;
import com.myfittinglife.app.wanandroid.bean.MyCollectionBean;
import com.myfittinglife.app.wanandroid.bean.MyCollectionBean2;
import com.myfittinglife.app.wanandroid.model.MyCollectionEssayModel;
import com.myfittinglife.app.wanandroid.model.UnCollectEssayModel;
import com.myfittinglife.app.wanandroid.net.GetCollectEssayListener;
import com.myfittinglife.app.wanandroid.net.UnCollectEssayLestener;
import com.myfittinglife.app.wanandroid.utils.ToastUtil;
import com.myfittinglife.app.wanandroid.view.ItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Author LD
 * @Time 2019.1.27
 * @Describe 我的收藏界面
 * @Modify
 */
public class MyCollectionActivity extends AppCompatActivity implements GetCollectEssayListener, UnCollectEssayLestener, BaseQuickAdapter.OnItemChildClickListener, BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.recycleview)
    RecyclerView recycleview;
    @BindView(R.id.tv_titlebar)
    TextView tvTitlebar;

    //请求我的收藏数据
    private MyCollectionEssayModel myCollectionEssayModel;

    //取消我的收藏
    private UnCollectEssayModel unCollectEssayModel;


    List<MyCollectionBean> myCollectionBeans;          //整合后的收藏数据
    private MyCollectionAdapter myCollectionAdapter;
    private int position;               //记录点击的是哪个取消收藏的按钮


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collection);
        ButterKnife.bind(this);
        initData();
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            default:
                break;
        }
    }

    /**
     * 初始化数据
     */
    public void initData() {

        tvTitlebar.setText("我的收藏");

        //获取我的收藏
        myCollectionBeans = new ArrayList<>();
        myCollectionEssayModel = new MyCollectionEssayModel(this);
        myCollectionEssayModel.getMyCollectedEssay();

        //删除我的收藏
        unCollectEssayModel = new UnCollectEssayModel(this);


        myCollectionAdapter = new MyCollectionAdapter(myCollectionBeans);
        recycleview.setLayoutManager(new LinearLayoutManager(this));//*会不会找不到activity?
        recycleview.setAdapter(myCollectionAdapter);
//        recycleview.addItemDecoration(new MyItemDecoration(2));        //添加分割线
        recycleview.addItemDecoration(new ItemDecoration(LinearLayout.VERTICAL, 1, Color.parseColor("#000000"), 1));        //添加分割线

        //收藏按钮点击事件
        myCollectionAdapter.setOnItemChildClickListener(this);
        myCollectionAdapter.setOnItemClickListener(this);



    }


    /**
     * 获取文章列表成功
     *
     * @param myCollectionBean2
     */
    @Override
    public void onGetCollectEssaySuccess(MyCollectionBean2 myCollectionBean2) {

        for (int i = 0; i < myCollectionBean2.getData().getDatas().size(); i++) {
            int itemType = myCollectionBean2.getData().getDatas().get(i).getChapterId() == 0 ? MyCollectionBean.OUTSITEESSAY : MyCollectionBean.INSITEESSAY;
            myCollectionBeans.add(new MyCollectionBean(itemType, myCollectionBean2.getData().getDatas().get(i)));
        }

        myCollectionAdapter.notifyDataSetChanged();//更新数据

    }

    /**
     * 获取文章列表失败
     *
     * @param str 错误信息
     */
    @Override
    public void onGetCollectEssayFailed(String str) {
        ToastUtil.showToast(getApplicationContext(), str);
    }

    /**
     * 取消收藏文章成功
     */
    @Override
    public void unCollectEssaySuccess() {
        //更新position
        myCollectionBeans.remove(position);
        myCollectionAdapter.notifyItemRemoved(position);
        ToastUtil.showToast(getApplicationContext(), "取消收藏成功");
        //
    }

    /**
     * 取消收藏文章失败
     */
    @Override
    public void unCollectEssayFailed() {
        ToastUtil.showToast(getApplicationContext(), "取消收藏失败");
    }

    /**
     * 点击收藏按钮的点击事件
     *
     * @param adapter
     * @param view
     * @param position
     */
    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        this.position = position;
        //取消收藏
        unCollectEssayModel.unCollectMyEssay(myCollectionBeans.get(position).getMyCollectionBean().getId(), myCollectionBeans.get(position).getMyCollectionBean().getOriginId());
    }

    /**
     * 子项的点击事件
     * @param adapter
     * @param view
     * @param position
     */
    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        ToastUtil.showToast(getApplicationContext(),""+position);

        Intent intent = new Intent(this,MyCollectionDetailActivity.class);
        intent.putExtra("parameters", myCollectionBeans.get(position).getMyCollectionBean());
        startActivity(intent);

    }
}
