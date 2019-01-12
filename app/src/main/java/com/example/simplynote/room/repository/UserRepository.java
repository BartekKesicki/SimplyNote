package com.example.simplynote.room.repository;

import com.example.simplynote.room.model.User;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface UserRepository {
    Completable insert(User user);
    Single<List<User>> getAll();
    Completable update(User user);
    Completable delete(User user);
}
