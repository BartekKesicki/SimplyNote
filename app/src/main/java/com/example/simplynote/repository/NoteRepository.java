package com.example.simplynote.repository;

import com.example.simplynote.room.model.Note;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface NoteRepository {
    Completable insert(Note note);
    Single<List<Note>> getAll();
    Completable update(Note note);
    Completable delete(Note note);
}
