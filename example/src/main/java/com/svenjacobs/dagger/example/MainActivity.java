package com.svenjacobs.dagger.example;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;

import com.svenjacobs.dagger.example.inject.InjectableActivity;
import com.svenjacobs.dagger.example.inject.components.ActivityComponent;
import com.svenjacobs.dagger.example.user.UserFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;

public class MainActivity extends InjectableActivity
        implements MainFragment.Listener, UserFragment.Listener {

    @Bind(R.id.container) FrameLayout mContainer;

    @Override
    public void onComponentCreated(@NonNull final ActivityComponent component) {
        super.onComponentCreated(component);

        component.inject(this);
    }

    @Override
    public void onUserLogin(@NonNull final String userName) {
        replaceFragment(UserFragment.newInstance(userName));
    }

    @Override
    public void onUserLogout() {
        replaceFragment(MainFragment.newInstance());
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (getSupportFragmentManager().findFragmentById(R.id.container) == null) {
            replaceFragment(MainFragment.newInstance());
        }
    }

    private void replaceFragment(@NonNull final Fragment fragment) {
        checkNotNull(fragment);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}
