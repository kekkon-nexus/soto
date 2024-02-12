package id.synth.soto.convention.build

import id.synth.soto.convention.build.dsl.javaLanguageVersion
import id.synth.soto.convention.build.dsl.libs

plugins {
    org.jetbrains.kotlin.jvm
}

kotlin {
    jvmToolchain {
        languageVersion.set(libs.versions.javaLanguageVersion)
    }
}
