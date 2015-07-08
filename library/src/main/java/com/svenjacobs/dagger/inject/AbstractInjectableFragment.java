package com.svenjacobs.dagger.inject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Generic base class for injectable fragments.
 * <p/>
 * {@link #onComponentCreated(Object)} will be called in {@link #onViewCreated(View, Bundle)} or in
 * {@link #onActivityCreated(Bundle)} (for Fragments without an UI).
 *
 * @see ComponentLifecycle
 */
public abstract class AbstractInjectableFragment<C> extends Fragment
        implements HasComponent<C>, ComponentLifecycle<C> {

    private C mComponent;

    @NonNull
    @Override
    public C getComponent() {
        return mComponent;
    }

    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Component creation is also called here for Fragments that don't have a UI
        createComponentIfRequired();
    }

    @Override
    public void onComponentCreated(@NonNull final C component) {
    }

    @Override
    public void onPostComponentCreated() {
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        createComponentIfRequired();
    }

    /**
     * Creates component instance.
     */
    protected abstract C createComponent();

    private void createComponentIfRequired() {
        if (mComponent != null) {
            return;
        }

        mComponent = createComponent();
        onComponentCreated(mComponent);
        onPostComponentCreated();
    }
}
