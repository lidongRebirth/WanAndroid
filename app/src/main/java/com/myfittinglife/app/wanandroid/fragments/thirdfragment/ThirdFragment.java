package com.myfittinglife.app.wanandroid.fragments.thirdfragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myfittinglife.app.wanandroid.App;
import com.myfittinglife.app.wanandroid.R;
import com.myfittinglife.app.wanandroid.bean.ProjectClassifyBean;
import com.myfittinglife.app.wanandroid.adapter.ViewPaperAdapter;
import com.myfittinglife.app.wanandroid.fragments.thirdfragment.tabfragments.ProjectListFragment;
import com.myfittinglife.app.wanandroid.model.CommentRequestModel;
import com.myfittinglife.app.wanandroid.net.OnNetFinishListener;
import com.squareup.leakcanary.RefWatcher;

import android.support.design.widget.TabLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author      LD
 * @Time        2019/1/21 16:24
 * @Describe    项目
 * @Modify
 */
public class ThirdFragment extends Fragment implements TabLayout.BaseOnTabSelectedListener, OnNetFinishListener {


    private TabLayout tablayout;
    private ViewPager viewpaper;

    private List<ProjectListFragment> fragmentList = new ArrayList<>();
    private List<String> tableTitleList = new ArrayList<>();
    private ViewPaperAdapter viewPaperAdapter;




    public ThirdFragment() {
    }

    public static ThirdFragment newInstance() {
        ThirdFragment thirdFragment = new ThirdFragment();
        return thirdFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_third, container, false);
        View view = inflater.inflate(R.layout.fragment_third, null, false); //*2019.1.29    减少快速滑动fragment导致的闪退

        tablayout = view.findViewById(R.id.tablayout);
        viewpaper = view.findViewById(R.id.viewpaper);
        initData();

        return view;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void initData(){
//        tablayout.addTab(tablayout.newTab());
//        tablayout.addTab(tablayout.newTab());
//        tablayout.setupWithViewPager(viewpaper);    //和viewpager联动
//
//        fragmentList.add(new tabFragment());
//        fragmentList.add(new tabFragment());
//        tableTitleList.add("标题一");
//        tableTitleList.add("标题二");
//
//        viewPaperAdapter = new ViewPaperAdapter(getActivity().getSupportFragmentManager(), fragmentList,tableTitleList);
//        viewpaper.setAdapter(viewPaperAdapter);
//        viewpaper.setCurrentItem(0);
//        tablayout.addOnTabSelectedListener(this);

        //请求网络项目分类标题数据
        /**
         * 获取项目分类列表
         */
        CommentRequestModel requestModel = new CommentRequestModel(this);
        requestModel.getProjectClassify();

        /**
         * 获取项目列表
         */
//        requestModel.getProjectList(1,294);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
    //----
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        updateTabTextView(tab,true);

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        updateTabTextView(tab,false);

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
    private void updateTabTextView(TabLayout.Tab tab, boolean isSelect) {       //选中时文字加粗用的
        if (isSelect) {
            try {
                java.lang.reflect.Field fieldView = tab.getClass().getDeclaredField("mView");
                fieldView.setAccessible(true);
                View view = (View) fieldView.get(tab);
                java.lang.reflect.Field fieldTxt = view.getClass().getDeclaredField("mTextView");
                fieldTxt.setAccessible(true);
                TextView tabSelect = (TextView) fieldTxt.get(view);
                tabSelect.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                tabSelect.setText(tab.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            try {
                java.lang.reflect.Field fieldView = tab.getClass().getDeclaredField("mView");
                fieldView.setAccessible(true);
                View view = (View) fieldView.get(tab);
                java.lang.reflect.Field fieldTxt = view.getClass().getDeclaredField("mTextView");
                fieldTxt.setAccessible(true);
                TextView tabSelect = (TextView) fieldTxt.get(view);
                tabSelect.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                tabSelect.setText(tab.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //----
    @Override
    public void onRequestFailed(String str) {
        Log.i("Model1", "getFailed: "+str);
    }

    @Override
    public void onRequestSuccess(List list) {

        List<ProjectClassifyBean.DataBean> classifyBeans = new ArrayList<>();
        classifyBeans = list;
        Log.i("Model1", "getSuccess: "+classifyBeans.get(0).getName());
        for(int i = 0;i<classifyBeans.size();i++){
            tablayout.addTab(tablayout.newTab());
            fragmentList.add(ProjectListFragment.newInstance(classifyBeans.get(i).getId()));
            tableTitleList.add(classifyBeans.get(i).getName());
        }
        tablayout.setupWithViewPager(viewpaper);    //和viewpager联动
        viewPaperAdapter = new ViewPaperAdapter(getActivity().getSupportFragmentManager(), fragmentList,tableTitleList);
        viewpaper.setAdapter(viewPaperAdapter);
        viewpaper.setCurrentItem(0);
        tablayout.addOnTabSelectedListener(this);
    }

    @Override
    public void onRequestSuccess(String string) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //监控Fragment
        RefWatcher refWatcher = App.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }
}
