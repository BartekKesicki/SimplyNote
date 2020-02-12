package com.example.simplynote.notes_list_fragment;

public class NotesListPresenter implements NotesListFragmentContract.NotesListFragmentPresenter<NotesListFragmentContract.NotesListView> {

    private NotesListFragmentContract.NotesListView view;

    @Override
    public void attach(NotesListFragmentContract.NotesListView view) {
        this.view = view;
    }

    public void performToLoadNotesList() {
        //todo load notes list
    }

    @Override
    public void detach() {
        this.view = NotesListFragmentContract.NULL;
    }
}
