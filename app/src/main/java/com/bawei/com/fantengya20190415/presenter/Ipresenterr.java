package com.bawei.com.fantengya20190415.presenter;

import com.bawei.com.fantengya20190415.view.activity.Ivieww;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/15 10:15:41
 * @Description:
 */
public interface Ipresenterr {
    void attachView(Ivieww iview);
    void detachView();
    void getData(String phone,String pwd);
}
