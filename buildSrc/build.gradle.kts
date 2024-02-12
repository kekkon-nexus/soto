plugins {
    `kotlin-dsl`
}

dependencies {
    // TODEL https://github.com/gradle/gradle/issues/15383
    implementation(files(libs::class.java.superclass.protectionDomain.codeSource.location))

    implementation(libs.bundles.buildSrc)
}
