package id.synth.soto.convention.build.dsl

import org.gradle.api.Project

internal val Project.autoNamespace: String
    get() {
        val `package` = rootProject.name
        val subpackage = project
            .path
            .removePrefix(":app")
            .replace(":", ".")

        return "id.synth.$`package`$subpackage"
    }
