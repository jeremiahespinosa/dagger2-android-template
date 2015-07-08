package com.svenjacobs.dagger.example.inject.components;

import android.content.Context;

import com.svenjacobs.dagger.example.inject.modules.ApplicationModule;
import com.svenjacobs.dagger.example.user.UserColorProvider;
import com.svenjacobs.dagger.example.user.UserGreetingService;
import com.svenjacobs.dagger.inject.AppContext;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = ApplicationModule.class)
@Singleton
public interface ApplicationComponent {

    @AppContext
    Context appContext();

    UserColorProvider userColorProvider();

    UserGreetingService userGreetingService();
}
