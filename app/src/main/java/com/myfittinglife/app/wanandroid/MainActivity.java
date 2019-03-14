package com.myfittinglife.app.wanandroid;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.myfittinglife.app.wanandroid.fragments.firstfragment.FirstFragment;
import com.myfittinglife.app.wanandroid.fragments.secondfragment.SecondFragment;
import com.myfittinglife.app.wanandroid.fragments.slidingfragment.SlidingFragment;
import com.myfittinglife.app.wanandroid.fragments.thirdfragment.ThirdFragment;
import com.myfittinglife.app.wanandroid.view.BadgeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Author      LD
 * @Time        2019.1.21
 * @Describe    玩Android主页面
 * @Modify
 */
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    @BindView(R.id.fl_container)
    FrameLayout flContainer;
    @BindView(R.id.rg_main)
    RadioGroup rgMain;
    @BindView(R.id.rb_home)
    RadioButton rbHome;
    @BindView(R.id.rb_officialAccount)
    RadioButton rbOfficialAccount;
    @BindView(R.id.rb_third)
    RadioButton rbThird;

    @BindView(R.id.iv_menu)
    ImageView ivMenu;
    @BindView(R.id.tv_titlebar)
    TextView tvTitlebar;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.titlebarlayout)
    LinearLayout titlebarlayout;
    //    @BindView(R.id.drawerlayout)
    private DrawerLayout drawerlayout;  //根布局id不能使用butterknife绑定

    //侧滑界面
    @BindView(R.id.fragment_sliding)
    FrameLayout fragmentSliding;


    //存放Fragment页面
    private List<Fragment> mFragmentList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        StatusBarUtil.setColor(this, Color.RED);//设置状态栏颜色
//        StatusBarUtil.setTranslucent(this);     //全透明状态栏

//        StatusBarUtil.setColorForDrawerLayout(this,drawerLayout,Color.,112);
//        mStatusBarColor = getResources().getColor(R.color.statusColor);

        drawerlayout = findViewById(R.id.drawerlayout);
        StatusBarUtil.setColorForDrawerLayout(this, drawerlayout, getResources().getColor(R.color.statusColor), 0);//设置DrawLayout透明和颜色 0代表全透明

        ButterKnife.bind(this);
        rgMain.setOnCheckedChangeListener(this);
        ivMenu.setOnClickListener(this);

        /**
         * 侧滑布局加入
         */
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_sliding, SlidingFragment.newInstance()).commitAllowingStateLoss();



        if (savedInstanceState == null) {

            changeFragment(FirstFragment.class.getName());      //首页
            tvTitlebar.setText("首页");

        }


        //覆盖在RadioGroup之上的LinearLayout的地三个占位子布局 （感觉效果不太好）
        Button button3 = findViewById(R.id.btn_myproject);
        remind(button3);


    }
    //RadioGroup中按钮的点击事件
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_home:
                changeFragment(FirstFragment.class.getName());
                tvTitlebar.setText("首页");
                break;
            case R.id.rb_officialAccount:
                changeFragment(SecondFragment.class.getName());
                tvTitlebar.setText("公众号");
                break;
            case R.id.rb_third:
                changeFragment(ThirdFragment.class.getName());
                tvTitlebar.setText("项目");
                break;
            default:
                break;
        }
    }

    /**
     * 显示目前的fragment
     *
     * @param tag
     */
    public void changeFragment(String tag) {
        hideFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);
        if (fragment != null) {
            transaction.show(fragment);
        } else {
            if (tag.equals(FirstFragment.class.getName())) {
                fragment = FirstFragment.newInstance();
            } else if (tag.equals(SecondFragment.class.getName())) {
                fragment = SecondFragment.newInstance();
            } else if (tag.equals(ThirdFragment.class.getName())) {
                fragment = ThirdFragment.newInstance();
            }
            mFragmentList.add(fragment);
            transaction.add(R.id.fl_container, fragment, fragment.getClass().getName());

        }
        transaction.commitAllowingStateLoss();
    }

    /**
     * 隐藏Fragment
     */
    public void hideFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (Fragment fragment : mFragmentList) {
            transaction.hide(fragment);
        }
        transaction.commitAllowingStateLoss();
    }

    /**
     * 点击事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_menu:

                drawerlayout.openDrawer(Gravity.LEFT);

                break;
            default:
                break;
        }
    }

    //BadgeView的具体使用
    private void remind(View view){
        // 创建一个BadgeView对象，view为你需要显示提醒的控件
        BadgeView badge1 = new BadgeView(this, view);
        // 需要显示的提醒类容
        badge1.setText("12");
        // 显示的位置.右上角,BadgeView.POSITION_BOTTOM_LEFT,下左，还有其他几个属性
        badge1.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);
        // 文本颜色
        badge1.setTextColor(Color.WHITE);
        // 提醒信息的背景颜色，自己设置
        badge1.setBadgeBackgroundColor(Color.RED);
        //还可以设置背景图片
        //badge1.setBackgroundResource(R.mipmap.icon_message_png);
        // 文本大小
        badge1.setTextSize(12);
        // 水平和竖直方向的间距
        badge1.setBadgeMargin(60, 10);
        //各边间隔
//        badge1.setBadgeMargin(5);
        //显示效果，如果已经显示，则隐藏，如果隐藏，则显示
        // badge1.toggle();
        // 显示
        badge1.show();
        //隐藏
        // badge1.hide();
        badge1.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);
    }


}
