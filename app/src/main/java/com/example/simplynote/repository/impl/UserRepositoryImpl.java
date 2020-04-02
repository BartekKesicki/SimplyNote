package com.example.simplynote.repository.impl;

import com.example.simplynote.room.dao.UserDao;
import com.example.simplynote.room.model.User;
import com.example.simplynote.repository.UserRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.functions.Action;

public class UserRepositoryImpl implements UserRepository {

    private UserDao userDao;

    @Inject
    public UserRepositoryImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Completable insert(final User user) {
        return Completable.fromAction(() -> userDao.insert(user));
    }

    @Override
    public Single<List<User>> getAll() {
        return Single.create(emitter -> emitter.onSuccess(userDao.getAll()));
    }

    @Override
    public Completable update(final User user) {
        return Completable.fromAction(() -> userDao.update(user));
    }

    @Override
    public Completable delete(final User user) {
        return Completable.fromAction(() -> userDao.delete(user));
    }
}
