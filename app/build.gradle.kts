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
}
apply(rootProject.file("gradle/android.gradle"))

dependencies {
    implementation(project(":core"))
    implementation(project(":feature:feature_a"))
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
    androidTestImplementation(Dep.AndroidX.Test.junit)
    androidTestImplementation(Dep.AndroidX.Test.espressoCore)
}