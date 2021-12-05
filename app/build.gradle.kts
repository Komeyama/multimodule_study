import dependencies.Dep

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    defaultConfig {
        applicationId = "com.komeyama.multimodule.study"
    }
    testOptions {
        unitTests.isIncludeAndroidResources = true
    }
}
apply(rootProject.file("gradle/android.gradle"))

dependencies {
    implementation(project(":core"))
    implementation(project(":feature:feature_a"))
    implementation(project(":feature:feature_b"))
    implementation(Dep.Kotlin.stdLib)
    implementation(Dep.AndroidX.coreKts)
    implementation(Dep.AndroidX.appCompat)
    implementation(Dep.AndroidX.fragmentKtx)
    implementation(Dep.Material.material)
    implementation(Dep.AndroidX.constraintLayout)
    implementation(Dep.Dagger.dagger)
    kapt(Dep.Dagger.annotationProcessor)
    implementation(Dep.Timber.timber)

    testImplementation(Dep.Test.junit)
    testImplementation(Dep.AndroidX.Test.junit)
    testImplementation(Dep.Test.Robolectric.robolectric)

    androidTestImplementation(Dep.AndroidX.Test.junit)
    androidTestImplementation(Dep.AndroidX.Test.espressoCore)
}