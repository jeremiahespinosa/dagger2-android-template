package com.svenjacobs.dagger.example.user;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.svenjacobs.dagger.example.R;
import com.svenjacobs.dagger.example.inject.InjectableFragment;
import com.svenjacobs.dagger.example.inject.components.FragmentComponent;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.google.common.base.Preconditions.checkNotNull;

public class UserFragment extends InjectableFragment {

    public interface Listener {

        void onUserLogout();
    }

    private static final String BUNDLE_USER_NAME = "USER_NAME";

    @Inject UserColorProvider mUserColorProvider;
    @Bind(R.id.user_greeting) TextView mUserGreeting;
    @Inject UserGreetingService mUserGreetingService;

    private Listener mListener;
    private String mUserName;

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);

        mListener = (Listener) context;
    }

    @Override
    public void onComponentCreated(@NonNull final FragmentComponent component) {
        super.onComponentCreated(component);

        component.inject(this);
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mUserName = getArguments().getString(BUNDLE_USER_NAME);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             final ViewGroup container,
                             final Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_user, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        ButterKnife.unbind(this);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mUserGreeting.setText(mUserGreetingService.getUserGreeting(mUserName));
        mUserGreeting.setTextColor(mUserColorProvider.getUserColor(mUserName));
    }

    @OnClick(R.id.logout_button)
    void onLogoutButtonClick() {
        mListener.onUserLogout();
    }

    public static UserFragment newInstance(@NonNull final String userName) {
        checkNotNull(userName);

        final Bundle arguments = new Bundle();
        arguments.putString(BUNDLE_USER_NAME, userName);

        final UserFragment fragment = new UserFragment();
        fragment.setArguments(arguments);

        return fragment;
    }
}
