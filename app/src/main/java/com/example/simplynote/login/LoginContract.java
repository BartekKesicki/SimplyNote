package com.example.simplynote.login;

import com.example.simplynote.base.BaseContract;

public class LoginContract {

    public interface LoginView extends BaseContract.BaseView {}

    public interface LoginPresenter<V> extends BaseContract.BasePresenter<V> {

    }

    public static LoginView NULL = new LoginView() {};
}
