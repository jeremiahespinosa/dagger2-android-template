package com.svenjacobs.dagger.example.inject;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import com.svenjacobs.dagger.example.ExampleApp;
import com.svenjacobs.dagger.example.inject.components.ActivityComponent;
import com.svenjacobs.dagger.example.inject.components.ApplicationComponent;

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

        return com.svenjacobs.dagger.inject.InjectHelper.getComponent(ActivityComponent.class,
                                                                      activity);
    }

    @NonNull
    public static ApplicationComponent getApplicationComponent(@NonNull final Context context) {
        checkNotNull(context);

        return ((ExampleApp) context.getApplicationContext()).getComponent();
    }
}
