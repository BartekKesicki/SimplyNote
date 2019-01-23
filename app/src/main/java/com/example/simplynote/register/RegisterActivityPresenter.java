package com.example.simplynote.register;

public class RegisterActivityPresenter implements RegisterContract.RegisterPresenter<RegisterContract.RegisterView> {

    RegisterContract.RegisterView view;

    //todo constructor with string provider

    @Override
    public void attach(RegisterContract.RegisterView view) {
        this.view = view;
    }

    void performToRegister(String login, String password, String confirmPassword) {
        //todo register
    }

    @Override
    public void detach() {
        view = RegisterContract.NULL;
    }
}
