package com.bawei.com.fantengya20190415.model;

import com.bawei.com.fantengya20190415.model.http.Http;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/15 10:12:12
 * @Description:
 */
public class Modell implements Imodell{
    String url = "http://172.17.8.100/small/user/v1/register";
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
