import dependencies.Dep

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

apply(rootProject.file("gradle/android.gradle"))

dependencies {
    implementation(project(":data:usecase_a"))
    implementation(project(":data:repository_a"))
    implementation(Dep.Kotlin.stdLib)
    implementation(Dep.Dagger.dagger)
    kapt(Dep.Dagger.annotationProcessor)
    implementation(Dep.AndroidX.coreKts)
    implementation(Dep.AndroidX.appCompat)
    implementation(Dep.Timber.timber)
    testImplementation(Dep.Test.junit)
}