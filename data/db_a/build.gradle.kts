import dependencies.Dep

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

apply(rootProject.file("gradle/android.gradle"))

dependencies {
    implementation(Dep.Kotlin.stdLib)
    implementation(Dep.Dagger.dagger)
    kapt(Dep.Dagger.annotationProcessor)
    implementation(Dep.Timber.timber)
    testImplementation(Dep.Test.junit)
}