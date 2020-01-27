package com.example.simplynote.di;

import android.content.Context;

import com.example.simplynote.repository.ChecklistItemRepository;
import com.example.simplynote.repository.ChecklistRepository;
import com.example.simplynote.repository.impl.ChecklistItemRepositoryImpl;
import com.example.simplynote.repository.impl.ChecklistRepositoryImpl;
import com.example.simplynote.room.dao.ChecklistDao;
import com.example.simplynote.room.dao.ChecklistItemDao;
import com.example.simplynote.room.dao.NoteDao;
import com.example.simplynote.room.dao.UserDao;
import com.example.simplynote.room.db.AppDatabase;
import com.example.simplynote.repository.NoteRepository;
import com.example.simplynote.repository.UserRepository;
import com.example.simplynote.repository.impl.NoteRepositoryImpl;
import com.example.simplynote.repository.impl.UserRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    public AppDatabase provideDatabase(Context context) {
        return AppDatabase.getInstance(context);
    }

    @Provides
    public UserDao provideUserDao(AppDatabase db) {
        return db.userDao();
    }

    @Provides
    public NoteDao provideNoteDao(AppDatabase db) {
        return db.noteDao();
    }

    @Provides
    public NoteRepository provideNoteRepository(NoteDao noteDao) {
        return new NoteRepositoryImpl(noteDao);
    }

    @Provides
    public UserRepository provideUserRepository(UserDao userDao) {
        return new UserRepositoryImpl(userDao);
    }

    @Provides
    public ChecklistDao provideChecklistDao(AppDatabase db) {
        return db.checklistDao();
    }

    @Provides
    public ChecklistItemDao provideChecklistItemDao(AppDatabase db) {
        return db.checklistItemDao();
    }

    @Provides
    public ChecklistItemRepository provideChecklistItemRepository(ChecklistItemDao checklistItemDao) {
        return new ChecklistItemRepositoryImpl(checklistItemDao);
    }

    @Provides
    public ChecklistRepository provideChecklistRepository(ChecklistDao checklistDao) {
        return new ChecklistRepositoryImpl(checklistDao);
    }
}
