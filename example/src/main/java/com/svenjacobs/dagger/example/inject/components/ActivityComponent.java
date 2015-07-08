package com.svenjacobs.dagger.example.inject.components;

import com.svenjacobs.dagger.example.MainActivity;
import com.svenjacobs.dagger.example.inject.modules.ActivityModule;
import com.svenjacobs.dagger.inject.PerActivity;

import dagger.Component;

@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
@PerActivity
public interface ActivityComponent extends ApplicationComponent {

    void inject(final MainActivity activity);
}
