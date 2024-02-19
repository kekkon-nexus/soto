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

package id.synth.soto.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.navigation
import id.synth.soto.feature.home.library.navigation.ROUTE_LIBRARY
import id.synth.soto.feature.home.library.navigation.libraryScreen

const val ROUTE_HOME = "home"

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    this.navigate(
        ROUTE_HOME,
        navOptions
    )
}

fun NavGraphBuilder.homeScreen() {
    navigation(startDestination = ROUTE_LIBRARY, route = ROUTE_HOME) {
        libraryScreen()
    }
}
