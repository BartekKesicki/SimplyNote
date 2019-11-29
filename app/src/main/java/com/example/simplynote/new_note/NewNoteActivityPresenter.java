package com.example.simplynote.new_note;

import android.text.TextUtils;

public class NewNoteActivityPresenter implements NewNoteContract.NewNotePresenter<NewNoteContract.NewNoteView> {

    private NewNoteContract.NewNoteView view;

    @Override
    public void attach(NewNoteContract.NewNoteView view) {
        this.view = view;
    }

    public void addNewNote(String title, String content) {
        view.clearAllErrors();
        if (TextUtils.isEmpty(title)) {
            view.setTitleError();
            return;
        }
        if (TextUtils.isEmpty(content)) {
            view.setContentError();
            return;
        }

        //todo add insertion of note
    }

    @Override
    public void detach() {
        this.view = NewNoteContract.NULL;
    }
}
