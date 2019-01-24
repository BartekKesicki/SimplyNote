package com.example.simplynote.login;


import com.example.simplynote.repository.UserRepository;
import com.example.simplynote.utils.StringProvider;

import javax.inject.Inject;

public class LoginActivityPresenter implements LoginContract.LoginPresenter<LoginContract.LoginView> {

    private LoginContract.LoginView view;

    private StringProvider mStringProvider;

    private UserRepository mUserRepository;

    @Inject
    public LoginActivityPresenter(StringProvider stringProvider, UserRepository userRepository) {
        this.mStringProvider = stringProvider;
        this.mUserRepository = userRepository;
    }

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
