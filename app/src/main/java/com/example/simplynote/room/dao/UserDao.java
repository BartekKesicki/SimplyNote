package com.example.simplynote.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.simplynote.room.model.User;

import java.util.List;

import io.reactivex.Single;

@Dao
interface UserDao {

    @Insert
    void insert(User user);

    @Query("SELECT * FROM Users")
    List<Single<User>> getAll();

    @Update
    void update(User user);

    @Delete
    void delete(long userId);
}
