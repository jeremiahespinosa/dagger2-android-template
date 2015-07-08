package com.svenjacobs.dagger.example.user;

import android.content.Context;
import android.support.annotation.NonNull;

import com.svenjacobs.dagger.example.R;
import com.svenjacobs.dagger.inject.AppContext;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class UserGreetingService {

    private final Context mContext;

    @Inject
    public UserGreetingService(@AppContext @NonNull final Context context) {
        mContext = checkNotNull(context);
    }

    public String getUserGreeting(@NonNull final String userName) {
        checkNotNull(userName);
        return mContext.getString(R.string.user_greeting, userName);
    }
}
