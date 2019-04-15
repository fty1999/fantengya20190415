package com.bawei.com.fantengya20190415.model;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/15 10:11:33
 * @Description:
 */
public interface Imodell {
    void RequestData(String phone, String pwd, CallBack callBack);
    interface CallBack {
        void onSuccess(String Data);
        void onFail(Exception e);
    }
}
