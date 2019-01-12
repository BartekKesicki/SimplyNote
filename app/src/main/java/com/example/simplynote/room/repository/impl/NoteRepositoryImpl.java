package com.example.simplynote.room.repository.impl;

import com.example.simplynote.room.dao.NoteDao;
import com.example.simplynote.room.model.Note;
import com.example.simplynote.room.repository.NoteRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.functions.Action;

public class NoteRepositoryImpl implements NoteRepository {

    private NoteDao noteDao;

    @Inject
    public NoteRepositoryImpl(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    @Override
    public Completable insert(final Note note) {
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                noteDao.insert(note);
            }
        });
    }

    @Override
    public Single<List<Note>> getAll() {
        return Single.create(new SingleOnSubscribe<List<Note>>() {
            @Override
            public void subscribe(SingleEmitter<List<Note>> emitter) throws Exception {
                emitter.onSuccess(noteDao.getAll());
            }
        });
    }

    @Override
    public Completable update(final Note note) {
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                noteDao.update(note);
            }
        });
    }

    @Override
    public Completable delete(final Note note) {
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                noteDao.delete(note);
            }
        });
    }
}
