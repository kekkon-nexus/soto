package id.synth.soto.convention.dependencies

import id.synth.soto.convention.build.dsl.libs

dependencies {
    add("testImplementation", libs.junit)
    add("androidTestImplementation", libs.androidx.test.ext.junit.ktx)
}
