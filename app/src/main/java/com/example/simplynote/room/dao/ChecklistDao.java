package com.example.simplynote.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.simplynote.room.model.Checklist;

import java.util.List;

@Dao
public interface ChecklistDao {

    @Insert
    void insert(Checklist checklist);

    @Query("SELECT * FROM Checklists")
    List<Checklist> getAll();

    @Update
    void update(Checklist checklist);

    @Delete
    void delete(Checklist checklist);
}
