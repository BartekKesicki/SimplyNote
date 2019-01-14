package com.example.simplynote.base;

public class BaseContract {

    public interface BasePresenter<V> {
        void attach(V view);
        void detach();
    }

    public interface BaseView {}
}
