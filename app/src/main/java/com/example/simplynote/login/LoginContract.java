package com.example.simplynote.login;

import com.example.simplynote.base.BaseContract;

public class LoginContract {

    public interface LoginView extends BaseContract.BaseView {
        void setLoginErrorMessage(String message);
        void redirectToRegisterActivity();
        void redirectToHomePage();
        void clearErrors();
    }

    public interface LoginPresenter<V> extends BaseContract.BasePresenter<V> {

    }

    public static LoginView NULL = new LoginView() {
        @Override
        public void setLoginErrorMessage(String message) { }

        @Override
        public void redirectToRegisterActivity() { }

        @Override
        public void redirectToHomePage() { }

        @Override
        public void clearErrors() { }
    };
}
