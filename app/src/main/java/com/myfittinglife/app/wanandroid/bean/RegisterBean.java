package com.myfittinglife.app.wanandroid.bean;

/**
 * @Author      LD
 * @Time        2019/1/25 17:45
 * @Describe    注册后的返回信息
 * @Modify
 */
public class RegisterBean {
    /**
     * data : null
     * errorCode : -1
     * errorMsg : 用户名已经被注册！
     */

    private Object data;
    private int errorCode;
    private String errorMsg;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "RegisterBean{" +
                "data=" + data +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
