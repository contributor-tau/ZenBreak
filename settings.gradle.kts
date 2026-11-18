rootProject.name = "ZenBreak"

include(":shared-core")
include(":shared-compose-core")
include(":shared-compose-settings")
include(":shared-compose-popup")
include(":androidApp")
include(":desktopApp")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}
