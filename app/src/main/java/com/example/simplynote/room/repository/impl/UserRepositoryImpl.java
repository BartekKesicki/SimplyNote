package com.example.simplynote.room.repository.impl;

import com.example.simplynote.room.model.User;
import com.example.simplynote.room.repository.UserRepository;

import java.util.List;

import io.reactivex.Single;

public class UserRepositoryImpl implements UserRepository {

    //todo fill methods
    @Override
    public void insert(User user) {

    }

    @Override
    public Single<List<User>> getAll() {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
