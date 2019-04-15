package com.bawei.com.fantengya20190415.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.com.fantengya20190415.R;
import com.bawei.com.fantengya20190415.model.bean.LoginBean;
import com.bawei.com.fantengya20190415.presenter.Presenter;
import com.bawei.com.fantengya20190415.view.Iview;
import com.google.gson.Gson;

public class MainActivity extends BaseActivity implements Iview {

    private EditText mima;
    private EditText user;
    private Button btn_login;
    private Presenter presenter;
    private TextView textView_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
    }
    @Override
    protected int setSelfView() {
        return R.layout.activity_main;
    }
    @Override
    protected void initView() {
        user = findViewById(R.id.editText_phone);
        mima = findViewById(R.id.editText_pwd);
        btn_login = findViewById(R.id.button_login);
        textView_register = findViewById(R.id.textView_register);
    }
    @Override
    protected void initData() {
        presenter = new Presenter();
        presenter.attachView(this);
        //设置点击事件
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = user.getText().toString();
                String pwd = mima.getText().toString();
                if (phone.equals("") && pwd.equals("")){
                    Toast.makeText(MainActivity.this,"用户名密码不能为空",Toast.LENGTH_LONG).show();
                }
                if (!phone.isEmpty() && !pwd.isEmpty()){
                    presenter.getData(phone,pwd);
                }
            }
        });

        //点击注册
        textView_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
                finish();
            }
        });
    }

    @Override
    public void getData(String data) {
        Gson gson = new Gson();
        LoginBean loginBean = gson.fromJson(data, LoginBean.class);
        if (loginBean.getStatus().equals("0000")){
            Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_LONG).show();
            startActivity(new Intent(MainActivity.this,HomeActivity.class));
            finish();
        }else {
            Toast.makeText(MainActivity.this,"登录失败",Toast.LENGTH_LONG).show();
        }
    }
}
