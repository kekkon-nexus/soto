package id.synth.soto.convention.build.dsl

import org.gradle.accessors.dm.LibrariesForLibs.VersionAccessors
import org.gradle.api.JavaVersion
import org.gradle.api.provider.Provider
import org.gradle.jvm.toolchain.JavaLanguageVersion

internal val VersionAccessors.javaVersion: Provider<JavaVersion>
    get() = this.java.map(JavaVersion::toVersion)

internal val VersionAccessors.javaLanguageVersion: Provider<JavaLanguageVersion>
    get() = this.java.map(JavaLanguageVersion::of)
