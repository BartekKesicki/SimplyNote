package com.example.simplynote.login;


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

    public void performToRedirectToRegisterPage() {
        view.redirectToRegisterActivity();
    }

    public void performToLogin(String login, String password) {
        //todo login
    }
}
