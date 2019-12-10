package com.example.simplynote.new_checklist;

public class NewChecklistActivityPresenter implements NewCheckListContract.NewCheckListPresenter<NewCheckListContract.NewCheckListView> {

    private NewCheckListContract.NewCheckListView view;

    @Override
    public void attach(NewCheckListContract.NewCheckListView view) {
        this.view = view;
    }

    public void performAddNewChecklistRow() {
        //todo add checklist row
    }

    public void submitChecklistForm() {
        //todo submit checklist row
    }

    @Override
    public void detach() {
        this.view = NewCheckListContract.NULL;
    }
}
