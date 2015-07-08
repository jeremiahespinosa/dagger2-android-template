package com.svenjacobs.dagger.example.user;

import android.graphics.Color;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class UserColorProvider {

    @Inject
    public UserColorProvider() {
    }

    public int getUserColor(@NonNull final String userName) {
        checkNotNull(userName);
        return hashCodeToColor(userName.hashCode());
    }

    private static int hashCodeToColor(final int hashCode) {
        final int r = (hashCode & 0xFF0000) >> 16;
        final int g = (hashCode & 0x00FF00) >> 8;
        final int b = hashCode & 0x0000FF;

        return Color.rgb(r, g, b);
    }
}
