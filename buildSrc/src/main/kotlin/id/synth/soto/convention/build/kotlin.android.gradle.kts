package id.synth.soto.convention.build

import com.android.build.api.dsl.CommonExtension
import id.synth.soto.convention.build.dsl.android
import id.synth.soto.convention.build.dsl.javaVersion
import id.synth.soto.convention.build.dsl.libs
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

plugins {
    org.jetbrains.kotlin.android
}

android {
    kotlinOptions {
        jvmTarget = libs.versions.javaVersion.get().toString()
    }
}

fun CommonExtension<*, *, *, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) =
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
