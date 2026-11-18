plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.kmp.library)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    jvmToolchain(17)

    // Android
    android {
        namespace = "dev.giuliopime.zenbreak.shared_compose_core"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    // Windows and Linux
    jvm("desktop")

    // iOS (Compose Multiplatform no longer publishes Apple x86_64 targets)
    iosArm64()
    iosSimulatorArm64()

    // macOS
    macosArm64()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.bundles.compose.common)
            implementation(project(":shared-core"))
        }

        val desktopMain by getting {
            dependencies {
                implementation(libs.compose.desktop)
            }
        }
    }
}
