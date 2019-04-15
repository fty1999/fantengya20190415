package com.bawei.com.fantengya20190415.view.activity;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bawei.com.fantengya20190415.R;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/15 09:39:02
 * @Description:
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setSelfView());
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int setSelfView();
}
