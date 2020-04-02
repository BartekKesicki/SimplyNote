package com.example.simplynote.repository.impl;

import com.example.simplynote.repository.ChecklistItemRepository;
import com.example.simplynote.room.dao.ChecklistItemDao;
import com.example.simplynote.room.model.ChecklistItem;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.functions.Action;

public class ChecklistItemRepositoryImpl implements ChecklistItemRepository {

    private ChecklistItemDao checklistItemDao;

    @Inject
    public ChecklistItemRepositoryImpl(ChecklistItemDao checklistItemDao) {
        this.checklistItemDao = checklistItemDao;
    }

    @Override
    public Completable insert(final List<ChecklistItem> checklistItems) {
        return Completable.fromAction(() -> checklistItemDao.insert(checklistItems));
    }

    @Override
    public Single<List<ChecklistItem>> getAll(final int checkListId) {
        return Single.create(emitter -> emitter.onSuccess(checklistItemDao.getAll(checkListId)));
    }

    @Override
    public Completable update(final ChecklistItem checklistItem) {
        return Completable.fromAction(() -> checklistItemDao.update(checklistItem));
    }

    @Override
    public Completable delete(final ChecklistItem checklistItem) {
        return Completable.fromAction(() -> checklistItemDao.delete(checklistItem));
    }
}
