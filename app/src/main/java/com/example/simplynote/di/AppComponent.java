package com.example.simplynote.di;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {AppModule.class, RepositoryModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
    void inject(AppController appController);
}
