package com.svenjacobs.dagger.example;

import android.app.Application;
import android.support.annotation.NonNull;

import com.svenjacobs.dagger.example.inject.components.ApplicationComponent;
import com.svenjacobs.dagger.example.inject.components.DaggerApplicationComponent;
import com.svenjacobs.dagger.example.inject.modules.ApplicationModule;
import com.svenjacobs.dagger.inject.HasComponent;

public class ExampleApp extends Application implements HasComponent<ApplicationComponent> {

    private ApplicationComponent mComponent;

    @NonNull
    @Override
    public ApplicationComponent getComponent() {
        return mComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
}
