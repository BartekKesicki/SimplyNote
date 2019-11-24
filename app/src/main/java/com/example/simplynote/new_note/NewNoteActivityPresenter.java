package com.example.simplynote.new_note;

public class NewNoteActivityPresenter implements NewNoteContract.NewNotePresenter<NewNoteContract.NewNoteView> {

    private NewNoteContract.NewNoteView view;

    @Override
    public void attach(NewNoteContract.NewNoteView view) {
        this.view = view;
    }

    @Override
    public void detach() {
        this.view = NewNoteContract.NULL;
    }
}
