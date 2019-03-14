package com.myfittinglife.app.wanandroid.fragments.firstfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.myfittinglife.app.wanandroid.App;
import com.myfittinglife.app.wanandroid.R;
import com.myfittinglife.app.wanandroid.utils.ToastUtil;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.squareup.leakcanary.RefWatcher;

/**
 * @Author      LD
 * @Time        2019/1/21 16:15
 * @Describe    首页
 * @Modify
 */
public class FirstFragment extends Fragment implements OnRefreshListener, OnLoadMoreListener {

    RefreshLayout refreshLayout;

    public FirstFragment() {
    }

    public static FirstFragment newInstance(){
        FirstFragment firstFragment = new FirstFragment();
        return firstFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_first,container,false);
        refreshLayout = view.findViewById(R.id.refreshlayout);

        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setOnLoadMoreListener(this);
        return view;
    }

    @Override
    public void onRefresh( RefreshLayout refreshLayout) {
        ToastUtil.showToast(getContext(),"刷新");
    }

    @Override
    public void onLoadMore( RefreshLayout refreshLayout) {
        ToastUtil.showToast(getContext(),"加载更多");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //监控Fragment
        RefWatcher refWatcher = App.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }
}
