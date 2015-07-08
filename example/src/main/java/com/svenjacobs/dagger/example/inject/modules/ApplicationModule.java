package com.svenjacobs.dagger.example.inject.modules;

import android.content.Context;
import android.support.annotation.NonNull;

import com.svenjacobs.dagger.example.ExampleApp;
import com.svenjacobs.dagger.inject.AppContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Main application module.
 */
@Module
public class ApplicationModule {

    private final ExampleApp mApplication;

    public ApplicationModule(@NonNull final ExampleApp application) {
        mApplication = checkNotNull(application);
    }

    @Provides
    @Singleton
    @AppContext
    Context provideAppContext() {
        return mApplication;
    }
}
