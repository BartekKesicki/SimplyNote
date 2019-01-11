package com.example.simplynote.room.repository;

import com.example.simplynote.room.model.Note;

import java.util.List;

import io.reactivex.Single;

public interface NoteRepository {
    void insert(Note note);
    Single<List<Note>> getAll();
    void update(Note note);
    void delete(Note note);
}
