package com.example.simplynote.main;

import com.example.simplynote.base.BaseContract;

public class MainContract {
    public interface MainView extends BaseContract.BaseView {}

    public interface MainPresenter<V> extends BaseContract.BasePresenter<V> {

    }

    public static MainView NULL = new MainView() {};
}
