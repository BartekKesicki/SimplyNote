package com.example.simplynote.login;

import com.example.simplynote.base.BaseContract;

public class LoginActivityPresenter implements LoginContract.LoginPresenter<LoginContract.LoginView> {

    private LoginContract.LoginView view;

    @Override
    public void attach(LoginContract.LoginView view) {
        this.view = view;
    }

    @Override
    public void detach() {
        view = LoginContract.NULL;
    }
}
