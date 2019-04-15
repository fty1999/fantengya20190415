package com.bawei.com.fantengya20190415.model;

import com.bawei.com.fantengya20190415.model.http.Http;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/15 09:26:08
 * @Description:
 */
public interface Imodel {
    void RequestData(String phone, String pwd, CallBack callBack);
    interface CallBack {
        void onSuccess(String Data);
        void onFail(Exception e);
    }
}
