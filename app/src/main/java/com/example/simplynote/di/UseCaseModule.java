package com.example.simplynote.di;

import android.content.Context;

import com.example.simplynote.utils.StringProvider;
import com.example.simplynote.utils.impl.StringProviderImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UseCaseModule {

    @Provides
    @Singleton
    public StringProvider provideStringProvider(Context context) {
        return new StringProviderImpl(context);
    }
}
