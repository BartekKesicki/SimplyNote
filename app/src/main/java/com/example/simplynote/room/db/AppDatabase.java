package com.example.simplynote.room.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.simplynote.room.dao.NoteDao;
import com.example.simplynote.room.dao.UserDao;
import com.example.simplynote.room.model.Note;
import com.example.simplynote.room.model.User;

@Database(entities = {User.class, Note.class}, version = 1,  exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "Invoice";

    private static AppDatabase appDatabase = null;

    public static AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build();
        }
        return appDatabase;
    }

    public static void cleanup() {
        appDatabase = null;
    }

    public abstract UserDao userDao();

    public abstract NoteDao noteDao();
}
