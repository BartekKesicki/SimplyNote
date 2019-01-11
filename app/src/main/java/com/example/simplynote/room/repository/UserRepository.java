package com.example.simplynote.room.repository;

import com.example.simplynote.room.model.User;

import java.util.List;

import io.reactivex.Single;

public interface UserRepository {
    void insert(User user);
    Single<List<User>> getAll();
    void update(User user);
    void delete(User user);
}
