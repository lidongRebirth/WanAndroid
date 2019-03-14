package com.myfittinglife.app.wanandroid.activities;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.myfittinglife.app.wanandroid.R;
import com.myfittinglife.app.wanandroid.bean.UserBean;
import com.myfittinglife.app.wanandroid.model.CommentRequestModel;
import com.myfittinglife.app.wanandroid.net.OnNetFinishListener;
import com.myfittinglife.app.wanandroid.utils.NullUtils;
import com.myfittinglife.app.wanandroid.utils.ToastUtil;
import com.myfittinglife.app.wanandroid.utils.UserUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Author LD
 * @Time 2019.1.25 12:28
 * @Describe 注册登录界面
 * @Modify
 */
public class LoginRegisterActivity extends AppCompatActivity implements TextWatcher, OnNetFinishListener {

    @BindView(R.id.et_account)                  //登录界面账号
            EditText etAccount;
    @BindView(R.id.et_password)                 //登录界面密码
            EditText etPassword;
    @BindView(R.id.tv_login)                    //登录界面登录按钮
            TextView tvLogin;
    @BindView(R.id.tv_register)                 //登录界面注册按钮
            TextView tvRegister;
    @BindView(R.id.et_register_account)         //注册界面账号
    EditText etRegisterAccount;
    @BindView(R.id.et_register_password)        //注册界面密码
    EditText etRegisterPassword;
    @BindView(R.id.et_check_password)           //注册界面确认密码
    EditText etCheckPassword;
    @BindView(R.id.register_tv_register)        //注册界面注册按钮
    TextView registerTvRegister;

    private boolean isLoginLayout = true;


    private ConstraintLayout loginLayout;
    private ConstraintLayout registerLayout;






    private CommentRequestModel commentRequestModel;

    private static final String TAG = "LoginRegister_ceshi";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginLayout = findViewById(R.id.loginLayout);
        registerLayout = findViewById(R.id.registerLayout);

        StatusBarUtil.setColor(this, Color.TRANSPARENT, 0);//设置状态栏颜色

        //EditText的监听
        initListener();

        commentRequestModel = new CommentRequestModel(this);

        etPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());


                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());

                }

                return false;
            }
        });


//        etPassword.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//                return false;
//            }
//        });

    }

    @OnClick({R.id.tv_login, R.id.tv_register,R.id.register_tv_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_login:

                commentRequestModel.login(etAccount.getText().toString().trim(),etPassword.getText().toString().trim());

                break;
            case R.id.tv_register:                  //进入注册页面

                registerLayout.setVisibility(View.VISIBLE);
                loginLayout.setVisibility(View.GONE);
                isLoginLayout = false;

                break;
            case R.id.register_tv_register:             //注册

                commentRequestModel.register(etRegisterAccount.getText().toString().trim(),etRegisterPassword.getText().toString().trim(),etCheckPassword.getText().toString().trim());

                break;
            default:
                break;
        }
    }

    /**
     * EditText框的监听
     */
    public void initListener() {

        //登录界面输入框的监听
        etAccount.addTextChangedListener(this);
        etPassword.addTextChangedListener(this);

        //注册界面输入框的监听
        etRegisterAccount.addTextChangedListener(this);
        etRegisterPassword.addTextChangedListener(this);
        etCheckPassword.addTextChangedListener(this);
    }

    //输入框输入前后的状态
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

        if(isLoginLayout){
            if (NullUtils.isStringEmpty(etAccount.getText().toString().trim()) || NullUtils.isStringEmpty(etPassword.getText().toString().trim())) {
                tvLogin.setEnabled(false);
                tvLogin.setBackgroundResource(R.drawable.gray_circle_background);
            } else {
                tvLogin.setEnabled(true);
                tvLogin.setBackgroundResource(R.drawable.blue_circle_background);
            }
        }else {
            if(NullUtils.isStringEmpty(etRegisterAccount.getText().toString().trim())||NullUtils.isStringEmpty(etRegisterPassword.getText().toString().trim())||NullUtils.isStringEmpty(etCheckPassword.getText().toString().trim())){
                registerTvRegister.setEnabled(false);
                registerTvRegister.setBackgroundResource(R.drawable.gray_circle_background);
            }else {
                registerTvRegister.setEnabled(true);
                registerTvRegister.setBackgroundResource(R.drawable.blue_circle_background);
            }

        }


    }

    @Override
    public void onRequestFailed(String str) {
        ToastUtil.showToast(this,str);
    }

    //只有登录成功才会回调该方法
    @Override
    public void onRequestSuccess(List list) {

        //将用户信息存储到SharePreference中
        List<UserBean> userBeans = list;
        UserBean userBean = userBeans.get(0);
        UserUtil.setUserBean(userBean);
        //将用户信息穿过去刷新SlideFragment布局，用于更新username

        EventBus.getDefault().post(userBean);      //③、其他活动中发送   注意：此处不需要再次进行注册和解绑，否则报错




    }

    @Override
    public void onRequestSuccess(String string) {
        ToastUtil.showToast(this,string);
        finish();
    }


}
