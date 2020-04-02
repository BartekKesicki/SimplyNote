package com.example.simplynote.repository.impl;

import com.example.simplynote.repository.ChecklistRepository;
import com.example.simplynote.room.dao.ChecklistDao;
import com.example.simplynote.room.model.Checklist;
import com.example.simplynote.room.model.ChecklistWithItems;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.functions.Action;

public class ChecklistRepositoryImpl implements ChecklistRepository {

    private ChecklistDao checklistDao;

    @Inject
    public ChecklistRepositoryImpl(ChecklistDao checklistDao) {
        this.checklistDao = checklistDao;
    }


    @Override
    public Single<Long> insert(final Checklist checklist) {
        return Single.create(emitter -> emitter.onSuccess(checklistDao.insert(checklist)));
    }

    @Override
    public Single<List<ChecklistWithItems>> getAll() {
        return Single.create(emitter -> emitter.onSuccess(checklistDao.getAll()));
    }

    @Override
    public Completable update(final Checklist checklist) {
        return Completable.fromAction(() -> checklistDao.update(checklist));
    }

    @Override
    public Completable delete(final Checklist checklist) {
        return Completable.fromAction(() -> checklistDao.delete(checklist));
    }
}
