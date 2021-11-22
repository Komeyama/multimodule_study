import dependencies.Dep

plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdkVersion(30)

    defaultConfig {
        applicationId  = "com.komeyama.multimodule.study"
        minSdkVersion(25)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            minifyEnabled(false)
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    android.compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    android.buildFeatures.viewBinding = true
}

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