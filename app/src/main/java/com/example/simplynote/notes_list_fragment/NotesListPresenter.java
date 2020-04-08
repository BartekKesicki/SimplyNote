package com.example.simplynote.notes_list_fragment;

import com.example.simplynote.repository.NoteRepository;
import com.example.simplynote.room.model.Note;
import com.example.simplynote.utils.BaseScheduler;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

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
        noteRepository.getAll()
                .subscribeOn(baseScheduler.io())
                .observeOn(baseScheduler.main())
                .subscribe(new SingleObserver<List<Note>>() {
                    @Override
                    public void onSubscribe(Disposable d) { }

                    @Override
                    public void onSuccess(List<Note> notes) {
                        view.createListView(notes);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showErrorMessage();
                    }
                });
    }

    public void performToRemoveNote(Note note, int position) {
        noteRepository.delete(note)
                .subscribeOn(baseScheduler.io())
                .observeOn(baseScheduler.main())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) { }

                    @Override
                    public void onComplete() {
                        view.showRemoveNoteSuccess(position);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showRemoveNoteFailure();
                    }
                });
    }

    @Override
    public void detach() {
        this.view = NotesListFragmentContract.NULL;
    }
}
