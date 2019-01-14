package com.example.simplynote.di;

import android.content.Context;

import com.example.simplynote.utils.BaseScheduler;
import com.example.simplynote.utils.impl.BaseSchedulerImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    //todo implement also RxScheduling
    @Provides
    @Singleton
    public BaseScheduler provideBaseScheduler() {
        return new BaseSchedulerImpl();
    }

    @Provides
    public Context provideContext(AppController appController) {
        return appController.getApplicationContext();
    }
}
