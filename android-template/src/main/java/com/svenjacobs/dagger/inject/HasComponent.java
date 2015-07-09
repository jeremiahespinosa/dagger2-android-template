package com.svenjacobs.dagger.inject;

import android.support.annotation.NonNull;

/**
 * Interfaces for classes providing a component.
 */
public interface HasComponent<C> {

    @NonNull
    C getComponent();
}
