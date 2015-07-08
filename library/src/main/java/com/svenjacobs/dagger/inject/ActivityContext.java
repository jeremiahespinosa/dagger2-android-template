package com.svenjacobs.dagger.inject;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Injections of {@link android.content.Context} annotated with this annotation will inject the
 * current Activity context.
 */
@Qualifier
@Retention(RUNTIME)
public @interface ActivityContext {
}
