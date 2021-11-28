import dependencies.Dep

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

apply(rootProject.file("gradle/android.gradle"))
android.buildFeatures.viewBinding = true

dependencies {
    implementation(project(":core"))
    implementation(project(":data:usecase_a"))
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
    testImplementation(Dep.Mockk.mockK)
    androidTestImplementation(Dep.AndroidX.Test.junit)
    androidTestImplementation(Dep.AndroidX.Test.espressoCore)
}