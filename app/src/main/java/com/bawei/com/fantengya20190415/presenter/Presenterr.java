package com.bawei.com.fantengya20190415.presenter;

import com.bawei.com.fantengya20190415.model.Imodel;
import com.bawei.com.fantengya20190415.model.Model;
import com.bawei.com.fantengya20190415.view.Iview;
import com.bawei.com.fantengya20190415.view.activity.Ivieww;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/15 10:16:05
 * @Description:
 */
public class Presenterr implements Ipresenterr{
    private Model model;
    Ivieww iview;
    @Override
    public void attachView(Ivieww iview) {
        model = new Model();
        this.iview = iview;
    }

    @Override
    public void detachView() {
        if (iview!=null){
            iview = null;
        }
        if (model!=null){
            model = null;
        }
        System.gc();
    }

    @Override
    public void getData(String phone, String pwd) {
        model.RequestData(phone, pwd, new Imodel.CallBack() {
            @Override
            public void onSuccess(String Data) {
                iview.getData(Data);
            }

            @Override
            public void onFail(Exception e) {

            }
        });
    }
}
