package com.example.winnie.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.winnie.mvpdemo.R;
import com.example.winnie.mvpdemo.databinding.ActivityDataBindBinding;

/**
 * Created by winnie on 2018/5/2.
 */

public class DataBindActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDataBindBinding dataBindBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_bind);

        UserEntity user = new UserEntity();
        user.setAge(34);
        user.setUsername("zhangsan");
        user.setNickname("张三");
        user.setUserface("baidu.com");
        dataBindBinding.setUser(user);

    }
}
