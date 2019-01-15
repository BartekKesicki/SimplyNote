package com.example.simplynote.main;

public class MainActivityPresenter implements MainContract.MainPresenter<MainContract.MainView> {

    private MainContract.MainView view;

    @Override
    public void attach(MainContract.MainView view) {
        this.view = view;
    }

    @Override
    public void detach() {
        this.view = MainContract.NULL;
    }
}
