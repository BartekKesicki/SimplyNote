package com.example.simplynote.di;

import com.example.simplynote.login.LoginActivity;
import com.example.simplynote.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector
    public abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector
    public abstract MainActivity bindMainActivity();
}
