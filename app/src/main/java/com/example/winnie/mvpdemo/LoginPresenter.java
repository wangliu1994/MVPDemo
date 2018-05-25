package com.example.winnie.mvpdemo;

/**
 * Created by winnie on 2018/5/2.
 */

public class LoginPresenter implements LoginInterface.Presenter {
    private LoginInterface.View view;
    private LoginInterface.Model model;

    public LoginPresenter(LoginInterface.View view) {
        this.view = view;
        model = new LoginModel();
    }

    @Override
    public void loadData() {
        String data = model.getData();
        view.setData(data);
    }

    @Override
    public void updateData(String data) {
        model.setData(data);
    }
}
