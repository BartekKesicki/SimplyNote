package com.example.simplynote.room.repository.impl;

import com.example.simplynote.room.model.Note;
import com.example.simplynote.room.repository.NoteRepository;

import java.util.List;

import io.reactivex.Single;

public class NoteRepositoryImpl implements NoteRepository {
    //todo fill methods
    @Override
    public void insert(Note note) {

    }

    @Override
    public Single<List<Note>> getAll() {
        return null;
    }

    @Override
    public void update(Note note) {

    }

    @Override
    public void delete(Note note) {

    }
}
