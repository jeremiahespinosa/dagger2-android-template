package com.svenjacobs.dagger.inject;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Annotation added to {@link android.content.Context} injections for injecting the application's
 * context.
 */
@Qualifier
@Retention(SOURCE)
public @interface AppContext {
}
