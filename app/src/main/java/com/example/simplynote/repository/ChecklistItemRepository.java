package com.example.simplynote.repository;

import com.example.simplynote.room.model.ChecklistItem;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface ChecklistItemRepository {
    Completable insert(List<ChecklistItem> checklistItems);
    Single<List<ChecklistItem>> getAll(int checkListId);
    Completable update(ChecklistItem checklistItem);
    Completable delete(ChecklistItem checklistItem);
}
