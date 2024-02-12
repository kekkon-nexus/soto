package id.synth.soto.convention.build

import id.synth.soto.convention.build.dsl.android
import id.synth.soto.convention.build.dsl.autoNamespace
import id.synth.soto.convention.build.dsl.javaVersion
import id.synth.soto.convention.build.dsl.libs

android {
    namespace = project.autoNamespace
    compileSdk = 34

    defaultConfig {
        minSdk = 28
    }

    compileOptions {
        sourceCompatibility = libs.versions.javaVersion.get()
        targetCompatibility = libs.versions.javaVersion.get()
    }
}
