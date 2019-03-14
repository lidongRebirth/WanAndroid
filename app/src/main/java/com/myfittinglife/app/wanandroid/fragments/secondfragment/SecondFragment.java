package com.myfittinglife.app.wanandroid.fragments.secondfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.myfittinglife.app.wanandroid.App;
import com.myfittinglife.app.wanandroid.R;
import com.myfittinglife.app.wanandroid.text.ContentAdapter;
import com.myfittinglife.app.wanandroid.text.NavigationAdapter;
import com.myfittinglife.app.wanandroid.text.NavigationItem;
import com.myfittinglife.app.wanandroid.utils.ToastUtil;
import com.squareup.leakcanary.RefWatcher;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Author      LD
 * @Time        2019/1/21 16:15
 * @Describe    第二个Fragment
 * @Modify
 */
public class SecondFragment extends Fragment {

    //左侧列表
    @BindView(R.id.recycleview_navi)
    RecyclerView recycleviewNavi;

    //右侧列表
    @BindView(R.id.recycleview_content)
    RecyclerView recycleviewContent;
    Unbinder unbinder;

    //*先测试一下
    private List<NavigationItem> navigationList;
    private NavigationAdapter navigationAdapter;    //左侧
    private ContentAdapter contentAdapter;          //右侧
    private int currPos = 0;                        //左侧当前所选位置
    private boolean shouldScroll;                   //是否应该滑动

    //*

    public SecondFragment() {
    }

    public static SecondFragment newInstance() {
        SecondFragment SecondFragment = new SecondFragment();
        return SecondFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        unbinder = ButterKnife.bind(this, view);
        //*------
        initData();//*  填充数据

        recycleviewNavi.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycleviewNavi.setAdapter(navigationAdapter);

        recycleviewContent.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycleviewContent.setAdapter(contentAdapter);
        //*-----
        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        //监控Fragment内存泄漏
        RefWatcher refWatcher = App.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //*--测试使用
    public void initData(){

        navigationList = new ArrayList<>();

        //*----右侧数据填充
        List<String> articles1 = new ArrayList<>();
        articles1.add("常用网站1");
        articles1.add("常用网站2");
        articles1.add("常用网站3");
        articles1.add("常用网站4");
        articles1.add("常用网站5");

        List<String> articles2 = new ArrayList<>();
        articles2.add("个人博客1");
        articles2.add("个人博客2");
        articles2.add("个人博客3");
        articles2.add("个人博客4");
        articles2.add("个人博客5");

        List<String> articles3 = new ArrayList<>();
        articles3.add("公司博客1");
        articles3.add("公司博客2");
        articles3.add("公司博客3");
        articles3.add("公司博客4");
        articles3.add("公司博客5");


        List<String> articles4 = new ArrayList<>();
        articles4.add("开发社区1");
        articles4.add("开发社区2");
        articles4.add("开发社区3");
        articles4.add("开发社区4");
        articles4.add("开发社区5");
//        List<String> articles = new ArrayList<>();
//        articles.add("1");
//        articles.add("2");
//        articles.add("3");
//        articles.add("4");
//        articles.add("5");

        List<String> articles5 = new ArrayList<>();
        articles5.add("常用工具1");
        articles5.add("常用工具2");
        articles5.add("常用工具3");
        articles5.add("常用工具4");
        articles5.add("常用工具5");

        List<String> articles6 = new ArrayList<>();
        articles6.add("查看源码1");
        articles6.add("查看源码2");
        articles6.add("查看源码3");
        articles6.add("查看源码4");
        articles6.add("查看源码5");

        List<String> articles7 = new ArrayList<>();
        articles7.add("在线学习1");
        articles7.add("在线学习2");
        articles7.add("在线学习3");
        articles7.add("在线学习4");
        articles7.add("在线学习5");

        List<String> articles8 = new ArrayList<>();
        articles8.add("开放平台1");
        articles8.add("开放平台2");
        articles8.add("开放平台3");
        articles8.add("开放平台4");
        articles8.add("开放平台5");

        List<String> articles9 = new ArrayList<>();
        articles9.add("互联网资讯1");
        articles9.add("互联网资讯2");
        articles9.add("互联网资讯3");
        articles9.add("互联网资讯4");
        articles9.add("互联网资讯5");

        List<String> articles10 = new ArrayList<>();
        articles10.add("求职招聘1");
        articles10.add("求职招聘2");
        articles10.add("求职招聘3");
        articles10.add("求职招聘4");
        articles10.add("求职招聘5");


        List<String> articles11 = new ArrayList<>();
        articles11.add("应用加固1");
        articles11.add("应用加固2");
        articles11.add("应用加固3");
        articles11.add("应用加固4");
        articles11.add("应用加固5");

        List<String> articles12 = new ArrayList<>();
        articles12.add("三方支付1");
        articles12.add("三方支付2");
        articles12.add("三方支付3");
        articles12.add("三方支付4");
        articles12.add("三方支付5");

        List<String> articles13 = new ArrayList<>();
        articles13.add("推送平台1");
        articles13.add("推送平台2");
        articles13.add("推送平台3");
        articles13.add("推送平台4");
        articles13.add("推送平台5");

        List<String> articles14 = new ArrayList<>();
        articles14.add("三方分享1");
        articles14.add("三方分享2");
        articles14.add("三方分享3");
        articles14.add("三方分享4");
        articles14.add("三方分享5");

        List<String> articles15 = new ArrayList<>();
        articles15.add("地图平台1");
        articles15.add("地图平台2");
        articles15.add("地图平台3");
        articles15.add("地图平台4");
        articles15.add("地图平台5");

        List<String> articles16 = new ArrayList<>();
        articles16.add("直播SDK1");
        articles16.add("直播SDK2");
        articles16.add("直播SDK3");
        articles16.add("直播SDK4");
        articles16.add("直播SDK5");

        List<String> articles17 = new ArrayList<>();
        articles17.add("IM即时通讯1");
        articles17.add("IM即时通讯2");
        articles17.add("IM即时通讯3");
        articles17.add("IM即时通讯4");
        articles17.add("IM即时通讯5");

        List<String> articles18 = new ArrayList<>();
        articles18.add("后端云1");
        articles18.add("后端云2");
        articles18.add("后端云3");
        articles18.add("后端云4");
        articles18.add("后端云5");
        //*----

        //左侧内容18个
        navigationList.add(new NavigationItem("常用网站"    ,articles1));
        navigationList.add(new NavigationItem("个人博客"    ,articles2));
        navigationList.add(new NavigationItem("公司博客"    ,articles3));
        navigationList.add(new NavigationItem("开发社区"    ,articles4));
        navigationList.add(new NavigationItem("常用工具"    ,articles5));
        navigationList.add(new NavigationItem("查看源码"    ,articles6));
        navigationList.add(new NavigationItem("在线学习"    ,articles7));
        navigationList.add(new NavigationItem("开放平台"    ,articles8));
        navigationList.add(new NavigationItem("互联网资讯"  ,articles9));
        navigationList.add(new NavigationItem("求职招聘"    ,articles10));
        navigationList.add(new NavigationItem("应用加固"    ,articles11));
        navigationList.add(new NavigationItem("三方支付"    ,articles12));
        navigationList.add(new NavigationItem("推送平台"    ,articles13));
        navigationList.add(new NavigationItem("三方分享"    ,articles14));
        navigationList.add(new NavigationItem("地图平台"    ,articles15));
        navigationList.add(new NavigationItem("直播SDK"     ,articles16));
        navigationList.add(new NavigationItem("IM即时通讯"  ,articles17));
        navigationList.add(new NavigationItem("后端云"      ,articles18));


        //左侧适配器
        navigationAdapter = new NavigationAdapter(R.layout.item_ceshi, navigationList);
        //右侧适配器
        contentAdapter = new ContentAdapter(R.layout.item_ceshi2, navigationList);

        //当点击时左侧的recyclerview滑动到相应位置（还有问题，点击后有的背景不变）
        navigationAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {       //左侧点击
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                selectItem(position);//改变点击位置的背景
                int firstVisibleItemPosition = getFirstVisibleItemPosition();
                if (currPos != firstVisibleItemPosition) {
                    scrollToPosition(recycleviewContent, currPos, true, true);
                }
            }
        });

        //滑动监听
        recycleviewNavi.addOnScrollListener(onNaviScrollListener);

        recycleviewContent.addOnScrollListener(onContentScrollListener);

    }


    //----------------
    //左侧滑动监听    （ //监听第三种情况，滚动停止之后再次进行滚动）
    private RecyclerView.OnScrollListener onNaviScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (shouldScroll && newState == RecyclerView.SCROLL_STATE_IDLE) {
                shouldScroll = false;
                scrollToPosition(recycleviewNavi, currPos, false, true);
            }
        }
    };

    //右侧内容滑动监听
    private RecyclerView.OnScrollListener onContentScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (shouldScroll) {
                return;
            }
            int firstVisibleItemPosition = getFirstVisibleItemPosition();
            if (currPos != firstVisibleItemPosition) {
                selectItem(firstVisibleItemPosition);
                scrollToPosition(recycleviewNavi, currPos, true, false);
            }
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (shouldScroll && newState == RecyclerView.SCROLL_STATE_IDLE) {
                shouldScroll = false;
                scrollToPosition(recycleviewContent, currPos, false, true);
            }
        }
    };

    //-------------
    //获取第一个item的位置
    private int getFirstVisibleItemPosition() {
        LinearLayoutManager layoutManager = (LinearLayoutManager) recycleviewContent.getLayoutManager();//*
        if (layoutManager == null) {
            return 0;
        }
        return layoutManager.findFirstVisibleItemPosition();
    }

    //通过滚动的类型来进行相应的滚动
    //滑动到指定位置
    private void scrollToPosition(RecyclerView recyclerView, int position, boolean needSmooth, boolean itemInScreenNeedScroll)  {
        int firstItem = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(0));
        int lastItem = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(recyclerView.getChildCount() - 1));
        if (position < firstItem) {
            //在屏幕上方，直接滚上去就是顶部
            if (needSmooth) {
                recyclerView.smoothScrollToPosition(position);
            } else {
                recyclerView.scrollToPosition(position);
            }
        } else if (position <= lastItem) {
            if (itemInScreenNeedScroll) {
                //在屏幕中，直接滚动到相应位置的顶部
                int movePosition = position - firstItem;
                if (movePosition >= 0 && movePosition < recyclerView.getChildCount()) {
                    //粘性头部，会占据一定的top空间，所以真是的top位置应该是减去粘性header的高度
                    int top = recyclerView.getChildAt(movePosition).getTop();
                    if (needSmooth) {
                        recyclerView.smoothScrollBy(0, top);
                    } else {
                        recyclerView.scrollBy(0, top);
                    }
                }
            }
        } else {
            //在屏幕下方，需要西安滚动到屏幕内，在校验
            shouldScroll = true;
            if (needSmooth) {
                recyclerView.smoothScrollToPosition(position);
            } else {
                recyclerView.scrollToPosition(position);
            }
            currPos = position;
        }
    }

    //通过点击事件来指定左侧选择的是哪一个，并改变其背景颜色
    private void selectItem(int position) {
        if (position < 0 || navigationList.size() < position) {
            return;
        }
        navigationList.get(currPos).setSelected(false); //先将原先的设为false不显示
        currPos = position;
        navigationList.get(position).setSelected(true);
        navigationAdapter.notifyDataSetChanged();
    }

    //*--
}
