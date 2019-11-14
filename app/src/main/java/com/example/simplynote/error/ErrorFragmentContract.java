package com.example.simplynote.error;

import com.example.simplynote.base.BaseContract;

public class ErrorFragmentContract {
    public interface ErrorFragmentView extends BaseContract.BaseView {}

    public interface ErrorFragmentPresenter<V> extends BaseContract.BasePresenter<V> {}

    public static ErrorFragmentView NULL = new ErrorFragmentView() {

    };
}
