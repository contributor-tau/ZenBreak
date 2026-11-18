// Since AGP 9 an Android application module can no longer apply the Kotlin Multiplatform plugin,
// so this is a plain Android app (AGP's built-in Kotlin support) that depends on the KMP libraries.
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "dev.giuliopime.zenbreak.app"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "dev.giuliopime.zenbreak.app"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(project(":shared-core"))
    implementation(project(":shared-compose-settings"))
    implementation(project(":shared-compose-popup"))

    implementation(libs.androidx.activity)
    implementation(libs.androidx.ktx)
    implementation(libs.koin.android)
}
