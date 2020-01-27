package com.example.simplynote.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.simplynote.room.model.ChecklistItem;

import java.util.List;

@Dao
public interface ChecklistItemDao {

    @Insert
    void insert(List<ChecklistItem> checklistItems);

    @Query("SELECT * FROM CheckListItems WHERE checklistId=:checkListId")
    List<ChecklistItem> getAll(int checkListId);

    @Update
    void update(ChecklistItem checklistItem);

    @Delete
    void delete(ChecklistItem checklistItem);
}
