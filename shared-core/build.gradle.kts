plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.plugin.serialization)
    alias(libs.plugins.android.kmp.library)
    alias(libs.plugins.native.coroutines)
    alias(libs.plugins.kmm.bridge.github)
}

val GROUP: String by project
val LIBRARY_VERSION: String by project

group = GROUP
version = LIBRARY_VERSION

kotlin {
    jvmToolchain(17)

    compilerOptions {
        // DefaultBreakManager is an expect/actual class (still Beta in Kotlin 2.x)
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }

    android {
        namespace = "dev.giuliopime.zenbreak.shared_core"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    // Windows and Linux targets
    jvm("desktop")

    // iOS
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "ZenBreakCoreKit"
            isStatic = true
        }
    }

    // macOS
    // macosX64 is deprecated since Kotlin 2.3.20 and Kotlin 2.4.x is the last line able to build it.
    // It is kept so the macOS app can still ship a universal (Intel + Apple Silicon) binary.
    listOf(
        macosX64(),
        macosArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "ZenBreakCoreKit"
            isStatic = true
        }
    }

    sourceSets {
        all {
            languageSettings.optIn("kotlin.experimental.ExperimentalObjCName")
        }

        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines)
            implementation(libs.kotlinx.serialization)
            implementation(libs.bundles.multiplatformSettings)
            implementation(libs.bundles.koin)
        }

        androidMain.dependencies {
            api(libs.androidx.datastore.preferences)
            api(libs.multiplatform.settings.datastore)
            api(libs.koin.android)
        }
    }
}

kmmbridge {
    frameworkName.set("ZenBreakCoreKit")
    // The XCFramework zip is uploaded as a GitHub Release asset, which (unlike GitHub Packages)
    // can be downloaded by Swift Package Manager without any credentials.
    gitHubReleaseArtifacts()
    spm(swiftToolVersion = "5.8") {
        iOS { v("15") }
        macOS { v("13") }
    }
}
