package com.svenjacobs.dagger.example.inject;

import com.svenjacobs.dagger.example.inject.components.ActivityComponent;
import com.svenjacobs.dagger.example.inject.components.DaggerActivityComponent;
import com.svenjacobs.dagger.example.inject.modules.ActivityModule;
import com.svenjacobs.dagger.inject.AbstractInjectableActivity;

public class InjectableActivity extends AbstractInjectableActivity<ActivityComponent> {

    @Override
    protected ActivityComponent createComponent() {
        return DaggerActivityComponent.builder()
                .applicationComponent(InjectHelper.getApplicationComponent(this))
                .activityModule(new ActivityModule(this))
                .build();
    }
}
