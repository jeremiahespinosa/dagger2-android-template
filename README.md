[ ![Download](https://api.bintray.com/packages/svenjacobs/android/com.svenjacobs.dagger%3Aandroid-template/images/download.svg) ](https://bintray.com/svenjacobs/android/com.svenjacobs.dagger%3Aandroid-template/_latestVersion)

Template and example project for [Dagger 2](http://google.github.io/dagger/) usage on Android.

See `android-template` for some generic base classes that may be used in any project and `example` for an example project.

For other examples see [here](https://github.com/google/dagger/tree/master/examples/android-simple),
[here](https://github.com/google/dagger/tree/master/examples/android-activity-graphs)
and [here](https://github.com/gk5885/dagger-android-sample).

## Usage

Start with [AbstractInjectableActivity](https://github.com/svenjacobs/dagger2-android-template/blob/master/android-template/src/main/java/com/svenjacobs/dagger/inject/AbstractInjectableActivity.java) and [AbstractInjectableFragment](https://github.com/svenjacobs/dagger2-android-template/blob/master/android-template/src/main/java/com/svenjacobs/dagger/inject/AbstractInjectableFragment.java). Your Activities and Fragments should extend from these base classes. Both classes implement the [ComponentLifecycle](https://github.com/svenjacobs/dagger2-android-template/blob/master/android-template/src/main/java/com/svenjacobs/dagger/inject/ComponentLifecycle.java) interface which introduces two new lifecycle methods `onComponentCreated(C component)` and `onPostComponentCreated()`.

### onComponentCreated

In your Activities this method is called in `onCreate` of the base class. In other words it's called right after the super call to `onCreate`. When `onComponentCreated` is called, the passed component should be used to inject dependencies into your Activity.

```java
@Inject MyDependency mMyDependency;

@Override
public void onComponentCreated(@NonNull MyComponent component) {
    super.onComponentCreated(component);

    component.inject(this);
}
```

The same goes for Fragments, however here `onComponentCreated` is called in `onAttach` of the base Fragment class.

### onPostComponentCreated

This new lifecycle method is called right after `onComponentCreated`. It may be used to access and configure the injected dependencies. For instance this method may be used in an abstract base class, which has some injectable dependencies declared via `@Inject MyDependency mSomeField`, to access these dependencies after they have been injected from a concrete class.

#### Why should an abstract class not implement `onComponentCreated`?

If an abstract class implements `onComponentCreated` as well as one or more of its concrete classes, the dependencies of the abstract class will be injected twice. Once when `onComponentCreated` is called on the abstract class and once when called on the concrete class. This might result in some unintended behaviour or at least some redundant object instances being created.

### createComponent

When extending from `AbstractInjectableActivity` or `AbstractInjectableFragment` the abstract method `C createComponent()` must be implemented. This method shall create the component via Dagger and return it. Since it's probably not desired to create a new component for every Activity and Fragment, now follows a recommended component setup.

## Component setup

How you structure your components is up to you, but here's a recommended setup as shown by the `example` project which works quite well for my Android projects.

Create three components `ApplicationComponent`, `ActivityComponent` and `FragmentComponent` and the corresponding modules `ApplicationModule`, `ActivityModule` and `FragmentModule`. `ApplicationComponent` handles all "global" dependencies that for instance apply to the `Application` class, services, any `Activity` or `Fragment`, etc. `ActivityComponent` handles all Activity-related dependencies and injection whereas `FragmentComponent` does the same for Fragments.

`FragmentComponent` extends from `ActivityComponent` and `ActivityComponent` from `ApplicationComponent`:

```
ApplicationComponent <- ActivityComponent <- FragmentComponent
```

TODO