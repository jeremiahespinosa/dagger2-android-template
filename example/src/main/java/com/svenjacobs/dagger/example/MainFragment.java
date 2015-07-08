package com.svenjacobs.dagger.example;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.svenjacobs.dagger.example.inject.InjectableFragment;
import com.svenjacobs.dagger.example.inject.components.FragmentComponent;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainFragment extends InjectableFragment {

    public interface Listener {

        void onUserLogin(@NonNull final String userName);
    }

    @Bind(R.id.user_name) TextView mUserName;

    private Listener mListener;

    @Override
    public void onAttach(final Activity activity) {
        super.onAttach(activity);

        mListener = (Listener) activity;
    }

    @Override
    public void onComponentCreated(@NonNull final FragmentComponent component) {
        super.onComponentCreated(component);

        component.inject(this);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater,
                             final ViewGroup container,
                             final Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        ButterKnife.unbind(this);
    }

    @OnClick(R.id.login_button)
    void onLoginButtonClick() {
        final String userName = mUserName.getText().toString();

        if (TextUtils.isEmpty(userName)) {
            return;
        }

        mListener.onUserLogin(userName);
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }
}
