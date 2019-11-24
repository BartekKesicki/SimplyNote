package com.example.simplynote.di;

import com.example.simplynote.home.HomeActivity;
import com.example.simplynote.login.LoginActivity;
import com.example.simplynote.main.MainActivity;
import com.example.simplynote.new_checkilist.NewCheckListActivity;
import com.example.simplynote.register.RegisterActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector
    public abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector
    public abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector
    public abstract RegisterActivity bindRegisterActivity();

    @ContributesAndroidInjector
    public abstract HomeActivity bindHomeActivity();

    @ContributesAndroidInjector
    public abstract NewCheckListActivity bindNewCheckListActivity();
}
