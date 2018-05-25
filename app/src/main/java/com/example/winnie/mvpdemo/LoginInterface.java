package com.example.winnie.mvpdemo;

/**
 * Created by winnie on 2018/5/2.
 */

public interface LoginInterface {

    interface View{
        void setData(String data);
    }

    interface Presenter{
        void loadData();

        void updateData(String data);
    }

    interface Model{
        String getData();

        void setData(String data);
    }

}
