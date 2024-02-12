package id.synth.soto.convention.presets

import id.synth.soto.convention.build.dsl.libs

plugins {
    id("id.synth.soto.convention.android.application")
    id("id.synth.soto.convention.androidx.compose")

    id("id.synth.soto.convention.dependencies.android.test")
    id("id.synth.soto.convention.dependencies.androidx.compose.ui.tooling")
    id("id.synth.soto.convention.dependencies.androidx.compose.ui.tooling.test")
}
