package com.bawei.com.fantengya20190415.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.bawei.com.fantengya20190415.R;
import com.bawei.com.fantengya20190415.model.bean.RegisterBean;
import com.bawei.com.fantengya20190415.presenter.Presenterr;
import com.google.gson.Gson;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/15 09:56:50
 * @Description:
 */
public class RegisterActivity extends BaseActivity implements Ivieww{
    private EditText mima;
    private EditText user;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
    }
    @Override
    protected int setSelfView() {
        return R.layout.activity_register;
    }
    @Override
    protected void initView() {
        user = findViewById(R.id.editText_phonee);
        mima = findViewById(R.id.editText_pwsdd);
        btn_login = findViewById(R.id.button);
    }
    @Override
    protected void initData() {
        final Presenterr presenterr = new Presenterr();
        presenterr.attachView(this);

        //设置点击事件
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = user.getText().toString();
                String pwd = mima.getText().toString();
                if (phone.equals("") && pwd.equals("")){
                    Toast.makeText(RegisterActivity.this,"用户名密码不能为空",Toast.LENGTH_LONG).show();
                }
                if (!phone.isEmpty() && !pwd.isEmpty()){
                    presenterr.getData(phone,pwd);
                }
            }
        });
    }

    @Override
    public void getData(String data) {
        Gson gson = new Gson();
        RegisterBean registerBean = gson.fromJson(data, RegisterBean.class);
        if (registerBean.getStatus().equals("0000")){
            Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_LONG).show();
            startActivity(new Intent(RegisterActivity.this,MainActivity.class));
            finish();
        }else {
            Toast.makeText(RegisterActivity.this,"注册失败",Toast.LENGTH_LONG).show();
        }
    }
}
