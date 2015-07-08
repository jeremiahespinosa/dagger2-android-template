package com.svenjacobs.dagger.example.inject;

import com.svenjacobs.dagger.example.inject.components.DaggerFragmentComponent;
import com.svenjacobs.dagger.example.inject.components.FragmentComponent;
import com.svenjacobs.dagger.example.inject.modules.FragmentModule;
import com.svenjacobs.dagger.inject.AbstractInjectableFragment;

public class InjectableFragment extends AbstractInjectableFragment<FragmentComponent> {

    @Override
    protected FragmentComponent createComponent() {
        return DaggerFragmentComponent.builder()
                .activityComponent(InjectHelper.getActivityComponent(getActivity()))
                .fragmentModule(new FragmentModule(this))
                .build();
    }
}
