import dependencies.Dep

plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    defaultConfig {
        applicationId = "com.komeyama.multimodule.study"
    }
}
apply(rootProject.file("gradle/android.gradle"))

dependencies {
    implementation(project(":feature:feature_a"))
    implementation(Dep.Kotlin.stdLib)
    implementation(Dep.AndroidX.coreKts)
    implementation(Dep.AndroidX.appCompat)
    implementation(Dep.Material.material)
    implementation(Dep.AndroidX.constraintLayout)
    testImplementation(Dep.Test.junit)
    androidTestImplementation(Dep.AndroidX.Test.junit)
    androidTestImplementation(Dep.AndroidX.Test.espressoCore)
}