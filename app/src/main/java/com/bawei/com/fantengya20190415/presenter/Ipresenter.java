package com.bawei.com.fantengya20190415.presenter;

import com.bawei.com.fantengya20190415.view.Iview;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/15 09:32:01
 * @Description:
 */
public interface Ipresenter {
    void attachView(Iview iview);
    void detachView();
    void getData(String phone,String pwd);
}
