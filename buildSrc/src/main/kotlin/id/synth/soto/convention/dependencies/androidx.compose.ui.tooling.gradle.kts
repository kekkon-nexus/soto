package id.synth.soto.convention.dependencies

import id.synth.soto.convention.build.dsl.libs

dependencies {
    // Android Studio Preview
    add("implementation", libs.androidx.compose.ui.tooling.preview)
    add("debugImplementation", libs.androidx.compose.ui.tooling)
}
