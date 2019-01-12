package com.example.simplynote.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    public Context provideContext(AppController appController) {
        return appController.getApplicationContext();
    }
}
