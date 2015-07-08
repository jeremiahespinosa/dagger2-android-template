package com.svenjacobs.dagger.example.inject;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import com.svenjacobs.dagger.example.ExampleApp;
import com.svenjacobs.dagger.example.inject.components.ActivityComponent;
import com.svenjacobs.dagger.example.inject.components.ApplicationComponent;
import com.svenjacobs.dagger.inject.HasComponent;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Helper methods to access {@link ApplicationComponent} and {@link ActivityComponent} from an
 * Activity or Fragment.
 */
public final class InjectHelper {

    private InjectHelper() {
    }

    @NonNull
    public static ActivityComponent getActivityComponent(@NonNull final Activity activity) {
        checkNotNull(activity);

        return getComponent(ActivityComponent.class, activity);
    }

    @NonNull
    public static ApplicationComponent getApplicationComponent(@NonNull final Context context) {
        checkNotNull(context);

        return ((ExampleApp) context.getApplicationContext()).getComponent();
    }

    @SuppressWarnings("unchecked")
    public static <C> C getComponent(@NonNull final Class<C> componentType,
                                     @NonNull final Activity activity) {

        checkNotNull(componentType);
        checkNotNull(activity);

        return componentType.cast(((HasComponent<C>) activity).getComponent());
    }
}
