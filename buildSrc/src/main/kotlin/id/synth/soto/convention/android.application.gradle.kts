package id.synth.soto.convention

plugins {
    com.android.application

    id("id.synth.soto.convention.build.android")
    id("id.synth.soto.convention.build.kotlin.android")
}

android {
    defaultConfig.targetSdk = compileSdk
}
