package id.synth.soto.convention

import id.synth.soto.convention.build.dsl.android
import id.synth.soto.convention.build.dsl.libs

android {
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}

dependencies {
    val composeBom = platform(libs.androidx.compose.bom)
    add("implementation", composeBom)
    add("androidTestImplementation", composeBom)

    add("implementation", libs.androidx.compose.material3)
}
