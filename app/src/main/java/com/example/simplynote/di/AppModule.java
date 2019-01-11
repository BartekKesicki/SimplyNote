package com.example.simplynote.di;

import android.content.Context;

import com.example.simplynote.room.dao.UserDao;
import com.example.simplynote.room.db.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    public Context provideContext(AppController appController) {
        return appController.getApplicationContext();
    }

    @Provides
    @Singleton
    public AppDatabase provideDatabase(Context context) {
        return AppDatabase.getInstance(context);
    }
}
