package com.example.winnie.mvvm;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.winnie.mvpdemo.R;

/**
 * Created by winnie on 2018/5/2.
 */

public class UserEntity {
    private String username;
    private String nickname;
    private int age;
    private String userface;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @BindingAdapter("bind:userFace")
    public static void getInternetImage(ImageView iv, String userface) {
        iv.setImageResource(R.drawable.ic_launcher_background);
        Log.d("tag", userface);
    }

    public String getUserface() {
        return userface;
    }

    public void setUserface(String userface) {
        this.userface = userface;
    }

    public void onItemClick(View view){
        Log.d("tag", "onItemClick");
    }
}
