package com.example.simplynote.home;

import com.example.simplynote.base.BaseContract;

public class HomeContract {

    public interface HomeView extends BaseContract.BaseView {}

    public interface HomePresenter<V> extends BaseContract.BasePresenter<V> {}

    public static HomeView NULL = new HomeView() { };
}
