package com.example.simplynote.register;

import com.example.simplynote.base.BaseContract;

public class RegisterContract {

    public interface RegisterView extends BaseContract.BaseView {}

    public interface RegisterPresenter<V> extends BaseContract.BasePresenter<V> {

    }

    public static RegisterView NULL = new RegisterView() {};
}
