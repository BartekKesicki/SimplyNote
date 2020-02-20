package com.example.simplynote.notes_list_fragment;

import com.example.simplynote.repository.NoteRepository;
import com.example.simplynote.utils.BaseScheduler;

import javax.inject.Inject;

public class NotesListPresenter implements NotesListFragmentContract.NotesListFragmentPresenter<NotesListFragmentContract.NotesListView> {

    private NotesListFragmentContract.NotesListView view;

    private BaseScheduler baseScheduler;

    private NoteRepository noteRepository;

    @Inject
    public NotesListPresenter(BaseScheduler baseScheduler, NoteRepository noteRepository) {
        this.baseScheduler = baseScheduler;
        this.noteRepository = noteRepository;
    }

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
