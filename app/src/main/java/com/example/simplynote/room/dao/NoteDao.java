package com.example.simplynote.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.simplynote.room.model.Note;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);

    @Query("SELECT * FROM Notes")
    List<Single<Note>> getAll();

    @Update
    void update(Note note);

    @Delete
    void delete(long noteId);
}
