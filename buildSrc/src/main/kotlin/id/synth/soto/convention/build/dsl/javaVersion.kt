package id.synth.soto.convention.build.dsl

import org.gradle.accessors.dm.LibrariesForLibs.VersionAccessors
import org.gradle.api.provider.Provider
import org.gradle.jvm.toolchain.JavaLanguageVersion

internal val VersionAccessors.javaLanguageVersion: Provider<JavaLanguageVersion>
    get() = this.java.map(JavaLanguageVersion::of)
