-dontobfuscate
-keep class com.svenjacobs.dagger.** { *; }

# Dagger
-dontwarn dagger.**

# Guava
-dontwarn sun.misc.Unsafe

# Butter Knife
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewInjector { *; }
-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

# Android Support
-keep class android.support.** { *; }