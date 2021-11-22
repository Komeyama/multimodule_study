package dependencies

object Dep {

    object GradlePlugin {
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
        const val android = "com.android.tools.build:gradle:4.2.1"
    }

    object Kotlin {
        const val version = "1.5.0"
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
    }

    object AndroidX {
        const val coreKts = "androidx.core:core-ktx:1.6.0"
        const val appCompat = "androidx.appcompat:appcompat:1.3.1"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.1"

        object Test {
            const val junit = "androidx.test.ext:junit:1.1.3"
            const val espressoCore = "androidx.test.espresso:espresso-core:3.4.0"
        }
    }

    object Material {
        private const val version = "1.4.0"
        const val material = "com.google.android.material:material:$version"
    }

    object Test {
        const val junit = "junit:junit:4.+"

    }
}