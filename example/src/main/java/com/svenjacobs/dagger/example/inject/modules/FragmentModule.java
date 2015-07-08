package com.svenjacobs.dagger.example.inject.modules;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.svenjacobs.dagger.inject.PerFragment;

import dagger.Module;
import dagger.Provides;

import static com.google.common.base.Preconditions.checkNotNull;

@Module
@PerFragment
public class FragmentModule {

    private final Fragment mFragment;

    public FragmentModule(@NonNull final Fragment fragment) {
        mFragment = checkNotNull(fragment);
    }

    @Provides
    @PerFragment
    Fragment provideFragment() {
        return mFragment;
    }
}
