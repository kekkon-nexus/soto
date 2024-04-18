import org.gradle.api.internal.lambdas.SerializableLambdas.action

/*
 * Copyright 2024 Soto contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

rootProject.name = "soto"

include(":app")

include(
    ":core:data",
    ":core:datastore",
    ":core:datastore-proto",
    ":core:model",
    ":core:source",
    ":core:ui",
)

include(
    ":feature:home",
    ":feature:home-browse",
    ":feature:home-library",
    ":feature:home-recent",
    ":feature:settings",
)

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
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

        mavenGithub(url = "https://maven.pkg.github.com/tclement0922/material-symbols-compose")

        // TODEL Kotlin 2.0
        maven(url = "https://androidx.dev/storage/compose-compiler/repository/")
    }
}

fun RepositoryHandler.mavenGithub(
    url: Any,
) = maven(url) {
    credentials {
        username = "yvvki"
        password = "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"
    }
}
