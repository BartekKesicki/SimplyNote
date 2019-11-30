package com.example.simplynote.new_note;

import android.text.TextUtils;

import com.example.simplynote.repository.NoteRepository;
import com.example.simplynote.room.model.Note;
import com.example.simplynote.utils.BaseScheduler;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

public class NewNoteActivityPresenter implements NewNoteContract.NewNotePresenter<NewNoteContract.NewNoteView> {

    private NewNoteContract.NewNoteView view;

    private NoteRepository noteRepository;
    private BaseScheduler baseScheduler;

    @Inject
    public NewNoteActivityPresenter(NoteRepository noteRepository, BaseScheduler baseScheduler) {
        this.noteRepository = noteRepository;
        this.baseScheduler = baseScheduler;
    }

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

        Note note = createNote(title, content);
        noteRepository.insert(note)
                .subscribeOn(baseScheduler.io())
                .observeOn(baseScheduler.main())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        //todo display toast
                        view.redirectToHomePage();
                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        //todo display error
                    }
                });
    }

    private Note createNote(String title, String content) {
        Note note = new Note();
        note.setCreationTime(System.currentTimeMillis());
        note.setContent(content);
        note.setTitle(title);
        return note;
    }

    @Override
    public void detach() {
        this.view = NewNoteContract.NULL;
    }
}
