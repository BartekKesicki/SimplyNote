package com.example.simplynote.di;

import android.content.Context;

import com.example.simplynote.room.dao.NoteDao;
import com.example.simplynote.room.dao.UserDao;
import com.example.simplynote.room.db.AppDatabase;
import com.example.simplynote.room.repository.NoteRepository;
import com.example.simplynote.room.repository.UserRepository;
import com.example.simplynote.room.repository.impl.NoteRepositoryImpl;
import com.example.simplynote.room.repository.impl.UserRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public AppDatabase provideDatabase(Context context) {
        return AppDatabase.getInstance(context);
    }

    @Provides
    @Singleton
    public UserDao provideUserDao(AppDatabase db) {
        return db.userDao();
    }

    @Provides
    @Singleton
    public NoteDao provideNoteDao(AppDatabase db) {
        return db.noteDao();
    }

    @Provides
    @Singleton
    public NoteRepository provideNoteRepository(NoteDao noteDao) {
        return new NoteRepositoryImpl(noteDao);
    }

    @Provides
    @Singleton
    public UserRepository provideUserRepository(UserDao userDao) {
        return new UserRepositoryImpl(userDao);
    }
}
