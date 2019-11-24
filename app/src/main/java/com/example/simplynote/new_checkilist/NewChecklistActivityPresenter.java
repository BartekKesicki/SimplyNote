package com.example.simplynote.new_checkilist;

public class NewChecklistActivityPresenter implements NewCheckListContract.NewCheckListPresenter<NewCheckListContract.NewCheckListView> {

    private NewCheckListContract.NewCheckListView view;

    @Override
    public void attach(NewCheckListContract.NewCheckListView view) {
        this.view = view;
    }

    //todo add methods for checklist layout

    @Override
    public void detach() {
        this.view = NewCheckListContract.NULL;
    }
}
