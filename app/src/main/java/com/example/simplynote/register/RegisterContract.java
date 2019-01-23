package com.example.simplynote.register;

import com.example.simplynote.base.BaseContract;

public class RegisterContract {

    public interface RegisterView extends BaseContract.BaseView {
        void setLoginError(String message);
        void setPasswordError(String message);
        void setConfirmPasswordMessage(String message);
        void clearAllErrors();
    }

    public interface RegisterPresenter<V> extends BaseContract.BasePresenter<V> {

    }

    public static RegisterView NULL = new RegisterView() {
        @Override
        public void setLoginError(String message) { }
        @Override
        public void setPasswordError(String message) { }
        @Override
        public void setConfirmPasswordMessage(String message) { }
        @Override
        public void clearAllErrors() { }
    };
}
