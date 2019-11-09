package com.example.simplynote.home;

public class HomeActivityPresenter implements HomeContract.HomePresenter<HomeContract.HomeView> {

    private HomeContract.HomeView view;

    @Override
    public void attach(HomeContract.HomeView view) {
        this.view = view;
    }

    @Override
    public void detach() {
        view = HomeContract.NULL;
    }
}
