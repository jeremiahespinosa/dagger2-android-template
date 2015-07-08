package com.svenjacobs.dagger.example.inject.modules;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import com.svenjacobs.dagger.inject.ActivityContext;
import com.svenjacobs.dagger.inject.PerActivity;

import dagger.Module;
import dagger.Provides;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Module providing Activity context per Activity.
 */
@Module
public class ActivityModule {

    private final Activity mActivity;

    public ActivityModule(@NonNull final Activity activity) {
        mActivity = checkNotNull(activity);
    }

    @Provides
    @PerActivity
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @PerActivity
    @ActivityContext
    Context provideActivityContext() {
        return mActivity;
    }
}
