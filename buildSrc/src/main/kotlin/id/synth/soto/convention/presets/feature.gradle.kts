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

package id.synth.soto.convention.presets

import id.synth.soto.convention.build.dsl.libs

plugins {
    id("id.synth.soto.convention.android.library")
    id("id.synth.soto.convention.androidx.compose")

    id("id.synth.soto.convention.hilt.android")

    id("id.synth.soto.convention.dependencies.android.test")
    id("id.synth.soto.convention.dependencies.androidx.compose.ui.tooling")
    id("id.synth.soto.convention.dependencies.androidx.compose.ui.tooling.test")
}

dependencies {
    add("implementation", libs.androidx.lifecycle.runtime.compose)
    add("implementation", libs.androidx.lifecycle.viewmodel.compose)

    add("implementation", libs.androidx.navigation.compose)
    add("implementation", libs.androidx.hilt.navigation.compose)
}
