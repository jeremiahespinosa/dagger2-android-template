package com.svenjacobs.dagger.example.inject.components;

import com.svenjacobs.dagger.example.MainFragment;
import com.svenjacobs.dagger.example.inject.modules.FragmentModule;
import com.svenjacobs.dagger.example.user.UserFragment;
import com.svenjacobs.dagger.inject.PerFragment;

import dagger.Component;

@Component(dependencies = ActivityComponent.class, modules = FragmentModule.class)
@PerFragment
public interface FragmentComponent extends ActivityComponent {

    void inject(final MainFragment fragment);

    void inject(final UserFragment fragment);
}
