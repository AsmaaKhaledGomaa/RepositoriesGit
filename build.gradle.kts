// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.android.library") version "8.1.2" apply false
    // Navigation
    id("androidx.navigation.safeargs") version "2.7.5" apply false
    // Hilt
    id ("com.google.dagger.hilt.android") version "2.48.1" apply false
    id ("org.jetbrains.kotlin.android.extensions") version "1.6.10" apply false
}