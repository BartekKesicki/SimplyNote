package com.example.simplynote.error;

public class ErrorFragmentPresenter implements ErrorFragmentContract.ErrorFragmentPresenter<ErrorFragmentContract.ErrorFragmentView> {

    private ErrorFragmentContract.ErrorFragmentView view;
    @Override
    public void attach(ErrorFragmentContract.ErrorFragmentView view) {
        this.view = view;
    }

    @Override
    public void detach() {
        this.view = ErrorFragmentContract.NULL;
    }
}
