package com.example.simplynote.di;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        AppModule.class,
        RepositoryModule.class,
        BuildersModule.class,
        FragmentBuildersModule.class,
        PresentersModule.class,
        UseCaseModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(AppController application);

        AppComponent build();
    }
    void inject(AppController appController);
}
