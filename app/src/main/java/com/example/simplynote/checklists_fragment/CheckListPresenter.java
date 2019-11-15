package com.example.simplynote.checklists_fragment;

public class CheckListPresenter implements CheckListFragmentContract.CheckListFragmentPresenter<CheckListFragmentContract.CheckListView> {

    private CheckListFragmentContract.CheckListView view;

    @Override
    public void attach(CheckListFragmentContract.CheckListView view) {
        this.view = view;
    }

    @Override
    public void detach() {
        this.view = CheckListFragmentContract.NULL;
    }
}
