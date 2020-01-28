package com.example.simplynote.repository;

import com.example.simplynote.room.model.Checklist;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface ChecklistRepository {

    Single<Long> insert(Checklist checklist);
    Single<List<Checklist>> getAll();
    Completable update(Checklist checklist);
    Completable delete(Checklist checklist);
}
