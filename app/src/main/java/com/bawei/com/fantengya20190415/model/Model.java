package com.bawei.com.fantengya20190415.model;

import com.bawei.com.fantengya20190415.model.http.Http;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/15 09:29:24
 * @Description:
 */
public class Model implements Imodel{
    String url = "http://172.17.8.100/small/user/v1/login";
    @Override
    public void RequestData(String phone, String pwd, final CallBack callBack) {
        Http.getInstance().getAsyncTask(url, phone, pwd, new Http.CallBack() {
            @Override
            public void onSuccess(String result) {
                callBack.onSuccess(result);
            }

            @Override
            public void onFail(int errorcode, String message) {

            }
        });
    }
}
