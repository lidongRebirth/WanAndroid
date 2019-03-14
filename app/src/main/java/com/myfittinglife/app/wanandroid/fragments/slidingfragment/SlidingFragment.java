package com.myfittinglife.app.wanandroid.fragments.slidingfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.myfittinglife.app.wanandroid.App;
import com.myfittinglife.app.wanandroid.R;
import com.myfittinglife.app.wanandroid.activities.LoginRegisterActivity;
import com.myfittinglife.app.wanandroid.activities.MyCollectionActivity;
import com.myfittinglife.app.wanandroid.bean.UserBean;

import com.myfittinglife.app.wanandroid.utils.ToastUtil;
import com.myfittinglife.app.wanandroid.utils.UserUtil;
import com.squareup.leakcanary.RefWatcher;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Author LD
 * @Time 2019/1/24 10:43
 * @Describe 左侧侧滑界面相关功能
 * @Modify
 */
public class SlidingFragment extends Fragment implements View.OnClickListener {


    @BindView(R.id.iv_background)
    ImageView ivBackground;
    @BindView(R.id.iv_headicon)
    ImageView ivHeadicon;
    @BindView(R.id.rel_mycollection)
    RelativeLayout relMycollection;
    @BindView(R.id.rel_set)
    RelativeLayout relSet;
    @BindView(R.id.rel_about)
    RelativeLayout relAbout;
    @BindView(R.id.tv_username)     //用于登录后显示用户名的
    TextView tvUsername;

    Unbinder unbinder;

    private static final String TAG = "ceshi126";



    public SlidingFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.drawerlayout, container, false);

        unbinder = ButterKnife.bind(this, view);

        ivBackground.setOnClickListener(this);
        ivHeadicon.setOnClickListener(this);
        relMycollection.setOnClickListener(this);
        relSet.setOnClickListener(this);
        relAbout.setOnClickListener(this);

        //采取相当于自动登录方式，若本地
        UserBean userBean = UserUtil.getUserBean();
        if(userBean!=null){
            tvUsername.setText(UserUtil.getUserBean().getData().getUsername());
        }

        //--
        EventBus.getDefault().register(this);   //注册订阅者①



        return view;
    }

    public static SlidingFragment newInstance() {

        SlidingFragment slidingFragment = new SlidingFragment();
        return slidingFragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_background:        //点击背景
                ToastUtil.showToast(getContext(), "背景图片");
                break;
            case R.id.iv_headicon:          //点击头像
//                Intent intent = new Intent();
//                intent.putExtra("listener",);

                startActivity(new Intent(getActivity(), LoginRegisterActivity.class));
                break;
            case R.id.rel_mycollection:     //点击我的收藏
                if(UserUtil.getUserBean()==null){
                    ToastUtil.showToast(getContext(), "请先登录");
                }else {
                    startActivity(new Intent(getContext(), MyCollectionActivity.class));
                }
                break;
            case R.id.rel_set:              //点击设置
                ToastUtil.showToast(getContext(), "设置");
                UserUtil.deleteCookies();   //*删除登录信息和cookies信息 ，此处要做两个更新，sliding更新和fragment更新
                break;
            case R.id.rel_about:            //点击关于我们
                ToastUtil.showToast(getContext(), "关于我们");
                break;
            default:
                break;
        }
    }

    /**
     * 定义处理接受的方法
     * @param userBean     自定义的事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)                                                        //③
    public void messageEventBus(UserBean userBean) {
        tvUsername.setText(userBean.getData().getUsername());
    }



    //*---------------------------------------------------------------------------------------------
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this); //防止内存泄漏                              //④
        //监控Fragment
        RefWatcher refWatcher = App.getRefWatcher(getActivity());
        refWatcher.watch(this);

    }



}
