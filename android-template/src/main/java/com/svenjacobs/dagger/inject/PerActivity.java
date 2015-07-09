package com.svenjacobs.dagger.inject;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Annotation for Dagger component that is scoped to an Activity.
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}
