import dependencies.Dep

plugins {
    id("com.android.library")
    id("kotlin-android")
}

apply(rootProject.file("gradle/android.gradle"))

dependencies {
    implementation(Dep.Kotlin.stdLib)
    testImplementation(Dep.Test.junit)
}