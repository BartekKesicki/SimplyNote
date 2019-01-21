package com.example.simplynote.register;

public class RegisterActivityPresenter implements RegisterContract.RegisterPresenter<RegisterContract.RegisterView> {

    RegisterContract.RegisterView view;

    @Override
    public void attach(RegisterContract.RegisterView view) {
        this.view = view;
    }

    @Override
    public void detach() {
        view = RegisterContract.NULL;
    }
}
