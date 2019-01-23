package com.example.simplynote.register;

import com.example.simplynote.repository.UserRepository;
import com.example.simplynote.utils.StringProvider;

import javax.inject.Inject;

public class RegisterActivityPresenter implements RegisterContract.RegisterPresenter<RegisterContract.RegisterView> {

    RegisterContract.RegisterView view;

    private StringProvider mStringProvider;

    private UserRepository mUserRepository;

    @Inject
    public RegisterActivityPresenter(StringProvider stringProvider, UserRepository userRepository) {
        this.mStringProvider = stringProvider;
        this.mUserRepository = userRepository;
    }

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
