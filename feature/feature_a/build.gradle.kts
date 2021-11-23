import dependencies.Dep

plugins {
    id("com.android.application")
    id("kotlin-android")
}

apply(rootProject.file("gradle/android.gradle"))
android.buildFeatures.viewBinding = true

dependencies {
    implementation(Dep.Kotlin.stdLib)
    implementation(Dep.AndroidX.coreKts)
    implementation(Dep.AndroidX.appCompat)
    implementation(Dep.Material.material)
    implementation(Dep.AndroidX.constraintLayout)
    testImplementation(Dep.Test.junit)
    androidTestImplementation(Dep.AndroidX.Test.junit)
    androidTestImplementation(Dep.AndroidX.Test.espressoCore)
}