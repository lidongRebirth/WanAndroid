package com.myfittinglife.app.wanandroid.fragments.thirdfragment.tabfragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.myfittinglife.app.wanandroid.App;
import com.myfittinglife.app.wanandroid.R;
import com.myfittinglife.app.wanandroid.activities.ProjectDetaiActivity;
import com.myfittinglife.app.wanandroid.bean.ProjectListBean;
import com.myfittinglife.app.wanandroid.adapter.TabFragmentAdapter;
import com.myfittinglife.app.wanandroid.model.CollectEssayModel;
import com.myfittinglife.app.wanandroid.model.CommentRequestModel;
import com.myfittinglife.app.wanandroid.model.UnCollectEssayModel;
import com.myfittinglife.app.wanandroid.net.OnCollectEssayListener;
import com.myfittinglife.app.wanandroid.net.OnNetFinishListener;
import com.myfittinglife.app.wanandroid.net.UnCollectEssayLestener;
import com.myfittinglife.app.wanandroid.utils.TimeUtil;
import com.myfittinglife.app.wanandroid.utils.ToastUtil;
import com.myfittinglife.app.wanandroid.view.MyItemDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.squareup.leakcanary.RefWatcher;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LD
 * @Time 2019/1/21 19:34
 * @Describe 项目列表Fragment, 用来展示文章列表（带添加功能：登录成功后的刷新，下拉刷新和上拉加载功能）
 * @Modify
 */
public class ProjectListFragment extends Fragment implements OnNetFinishListener, BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.OnItemChildClickListener, OnLoadMoreListener, OnCollectEssayListener, UnCollectEssayLestener, OnRefreshListener {

    private static final String TAG = "ProjectListFragment";
    private int currentPage = 1;
    private RecyclerView recyclerView;
    private TabFragmentAdapter tabFragmentAdapter;
    private List<ProjectListBean.DataBean.DatasBean> projectListBeans;  //所有项目bean列表
    private SmartRefreshLayout smartRefreshLayout;
    private CommentRequestModel requestModel;

    private CollectEssayModel collectEssayModel;        //收藏文章
    private UnCollectEssayModel unCollectEssayModel;    //取消收藏文章

    private int position;       //记录收藏的点击位置


    public ProjectListFragment() {
    }

    public static ProjectListFragment newInstance(int cid) {
        ProjectListFragment projectListFragment = new ProjectListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("cid", cid);                       //项目id(分类)
        projectListFragment.setArguments(bundle);
        return projectListFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getArguments() != null) {       //获得的参数不为空时发起请求
            requestModel = new CommentRequestModel(this);
            requestModel.getProjectList(currentPage, getArguments().getInt("cid"));

            collectEssayModel = new CollectEssayModel(this);
            unCollectEssayModel = new UnCollectEssayModel(this);
        }
//        View view = inflater.inflate(R.layout.fragment_projectlist, container, false);//
        View view = inflater.inflate(R.layout.fragment_projectlist, null, false);//*2019.1.29   减少快速滑动fragment导致的闪退
        smartRefreshLayout = view.findViewById(R.id.smartRefreshLayout);        //智能刷新布局
        recyclerView = view.findViewById(R.id.recycleview);
        smartRefreshLayout.setOnLoadMoreListener(this);
        smartRefreshLayout.setOnRefreshListener(this);


        projectListBeans = new ArrayList<>();
        tabFragmentAdapter = new TabFragmentAdapter(R.layout.item_projectlist, projectListBeans);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));//*会不会找不到activity?
        recyclerView.setAdapter(tabFragmentAdapter);
        recyclerView.addItemDecoration(new MyItemDecoration(2));        //添加分割线

        tabFragmentAdapter.setOnItemClickListener(this);            //item点击事件
        tabFragmentAdapter.setOnItemChildClickListener(this);       //子item点击事件
        return view;
    }

    /**
     * 初始化列表数据
     */
    public void initData(List<ProjectListBean.DataBean.DatasBean> datasBeanList) {
        //刷新
        tabFragmentAdapter.notifyDataSetChanged();
    }


    @Override
    public void onRequestFailed(String str) {
        Log.i(TAG, "onRequestFailed: " + str);
    }

    /**
     * 请求成功
     *
     * @param list 获取到的列表
     */
    @Override
    public void onRequestSuccess(List list) {
        smartRefreshLayout.finishLoadMore();
        smartRefreshLayout.finishRefresh();

        projectListBeans.addAll((List<ProjectListBean.DataBean.DatasBean>) list);
//        projectListBeans = (List<ProjectListBean.DataBean.DatasBean>) list;
        if (projectListBeans != null && projectListBeans.size() > 0) {
            initData(projectListBeans);

        } else {     //IndexOutOfBoundsException可能会出现错误,没有内容时防止为空
            //加载数据为空的布局
            View emptyView = getLayoutInflater().inflate(R.layout.item_emptydata, null);
            tabFragmentAdapter.setEmptyView(emptyView);
        }

    }

    @Override
    public void onRequestSuccess(String string) {

    }



    /**
     * 列表项的点击事件
     * @param adapter
     * @param view
     * @param position
     */
    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

        Intent intent = new Intent(getActivity(), ProjectDetaiActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putParcelable("data",projectListBeans.get(position));


//        bundle.putString("url",projectListBeans.get(position).getLink());
//        bundle.putString("title",projectListBeans.get(position).getTitle());
        intent.putExtra("parameters", projectListBeans.get(position));
        startActivity(intent);
    }

    /**
     * 收藏的点击事件
     * @param adapter
     * @param view
     * @param position
     */
    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        this.position = position;

        if (!TimeUtil.isFastClick()) {      //判断是否快速点击
            if (projectListBeans.get(position).isCollect()) {
                //取消收藏
                unCollectEssayModel.unCollectEssay(projectListBeans.get(position).getId());
            } else {
                //收藏文章
                collectEssayModel.CollectInSiteEssay(projectListBeans.get(position).getId());
            }
        }
    }


    //收藏文章成功
    @Override
    public void onEssayCollectedSuccess() {
        ToastUtil.showToast(getContext(), "收藏成功");
        projectListBeans.get(position).setCollect(true);
//        tabFragmentAdapter.notifyDataSetChanged();        //通知所有数据都发生了变化
        tabFragmentAdapter.notifyItemChanged(position);     //通知该位置的数据发生了变化


    }

    //收藏文章失败
    @Override
    public void onEssayCollectedFailed() {

        ToastUtil.showToast(getContext(), "收藏失败");
    }

    //取消收藏文章成功
    @Override
    public void unCollectEssaySuccess() {
        ToastUtil.showToast(getContext(), "取消收藏成功");
        projectListBeans.get(position).setCollect(false);
        tabFragmentAdapter.notifyItemChanged(position);     //通知该位置的数据发生了变化
    }

    //取消收藏文章失败
    @Override
    public void unCollectEssayFailed() {

        ToastUtil.showToast(getContext(), "取消收藏失败");
    }

    /**
     * 布局刷新（还不行）
     * @param refreshLayout
     */
    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        if(requestModel!=null) {
            Log.i(TAG, "onRefresh: ");
            requestModel.getProjectList(1, getArguments().getInt("cid"));
        }
    }

    /**
     * 加载更多
     * @param refreshLayout
     */
    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        currentPage = currentPage + 1;
        requestModel.getProjectList(currentPage, getArguments().getInt("cid"));

    }

//    /**
//     * 滑动至顶部
//     */
//    public void scrollToTop(){
//        if(projectListBeans != null && projectListBeans.size() > 0) {
//            recyclerView.scrollToPosition(0);
//        }
//    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        //监控Fragment
        RefWatcher refWatcher = App.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }
}
