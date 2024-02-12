rootProject.name = "Soto"

include(":app")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()

        // TODEL Kotlin 2.0
        maven(url = "https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev/")
    }
}

plugins {
    // Automatically configures toolchain management
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()

        // TODEL Kotlin 2.0
        maven(url = "https://androidx.dev/storage/compose-compiler/repository/")
        maven(url = "https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev/")
    }
}
