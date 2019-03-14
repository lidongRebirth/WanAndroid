package com.myfittinglife.app.wanandroid.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.myfittinglife.app.wanandroid.R;
import com.myfittinglife.app.wanandroid.bean.ProjectListBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Author      LD
 * @Time        2019.1.23
 * @Describe    项目详情界面（WebView加载网址）
 * @Modify
 */
public class ProjectDetaiActivity extends AppCompatActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_more)
    ImageView ivMore;
    @BindView(R.id.webview)
    WebView webview;
    private String projectUrl;
    private String title;
    private static final String TAG = "ProjectDetaiActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);
        ButterKnife.bind(this);

        initConfiguration();

        initData();


    }

    @OnClick({R.id.iv_back, R.id.iv_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_more:
                Toast.makeText(this, "分享+收藏", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    /**
     * WebView的相关配置
     */
    public void initConfiguration() {

        WebSettings webSetting = webview.getSettings();
        webSetting.setJavaScriptEnabled(true);                                                      //支持js
        webSetting.setJavaScriptCanOpenWindowsAutomatically(true);                                  //支持通过js打开新窗口
        webSetting.setAllowFileAccess(true);                                                        //设置可以访问文件
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);                  //支持内容重新布局
        webSetting.setSupportZoom(true);                                                            //支持缩放，默认为true。是下面那个的前提。
        webSetting.setBuiltInZoomControls(true);                                                    //设置支持缩放
        webSetting.setUseWideViewPort(true);                                                        //将图片调整到适合webview的大小
        webSetting.setSupportMultipleWindows(true);                                                 //多窗口
        webSetting.setLoadWithOverviewMode(true);                                                  //缩放至屏幕的大小
        webSetting.setAppCacheEnabled(true);                                                        //缓存模式，设置是否打开，默认关闭，即H5缓存无法使用
        webSetting.setCacheMode(WebSettings.LOAD_NO_CACHE);                                          //设置缓冲的模式:关闭webview中缓存

    }

    public void initData() {
        //获取项目处  点击列表传过来的参数
        ProjectListBean.DataBean.DatasBean datasBean = getIntent().getParcelableExtra("parameters");
        projectUrl = datasBean.getLink();       //网页地址
        title = datasBean.getTitle();           //标题

        if (!TextUtils.isEmpty(projectUrl)) {
            webview.loadUrl(projectUrl);
        }
        tvTitle.setText(title);
    }

    @Override
    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
            return;
        }
        super.onBackPressed();
    }
}
