package com.bawei.com.fantengya20190415.presenter;

import com.bawei.com.fantengya20190415.model.Imodel;
import com.bawei.com.fantengya20190415.model.Model;
import com.bawei.com.fantengya20190415.view.Iview;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/15 09:33:16
 * @Description:
 */
public class Presenter implements Ipresenter{

    private Model model;
    Iview iview;
    @Override
    public void attachView(Iview iview) {
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
