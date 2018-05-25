package com.example.winnie.mvpdemo;

import android.text.TextUtils;

/**
 * Created by winnie on 2018/5/2.
 */

public class LoginModel implements LoginInterface.Model {
    private String data;

    @Override
    public String getData() {
        if(TextUtils.isEmpty(data)) {
            return "我是model伪造的数据";
        }else {
            return data;
        }
    }

    @Override
    public void setData(String data) {
        this.data = data;
    }
}
