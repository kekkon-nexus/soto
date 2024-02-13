/*
 * Copyright 2024 Soto contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package id.synth.soto.convention.build

import com.android.build.api.dsl.CommonExtension
import id.synth.soto.convention.build.dsl.android
import id.synth.soto.convention.build.dsl.javaVersion
import id.synth.soto.convention.build.dsl.libs
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

plugins {
    org.jetbrains.kotlin.android
}

android {
    kotlinOptions {
        jvmTarget = libs.versions.javaVersion.get().toString()
    }
}

fun CommonExtension<*, *, *, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) =
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
