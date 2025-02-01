// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    extra.apply {
        set("compose_version", "1.5.15")
        set("hilt_version", "2.52")
    }

    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:${property("hilt_version")}")
    }
}

plugins {
    id("com.android.application") version "8.7.1" apply false
    id("com.android.library") version "8.7.1" apply false
    id("org.jetbrains.kotlin.android") version "2.0.21" apply false
    id("org.jetbrains.kotlin.plugin.parcelize") version "2.0.21" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.21" apply false
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}