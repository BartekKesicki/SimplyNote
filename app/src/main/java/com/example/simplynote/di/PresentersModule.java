package com.example.simplynote.di;

import com.example.simplynote.register.RegisterActivityPresenter;
import com.example.simplynote.repository.UserRepository;
import com.example.simplynote.utils.StringProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentersModule {

    @Provides
    @Singleton
    public RegisterActivityPresenter provideRegisterActivityPresenter(StringProvider stringProvider, UserRepository userRepository) {
        return new RegisterActivityPresenter(stringProvider, userRepository);
    }
}
