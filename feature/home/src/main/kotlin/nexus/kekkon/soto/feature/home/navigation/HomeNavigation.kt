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

package nexus.kekkon.soto.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.navigation
import nexus.kekkon.soto.feature.home.browse.navigation.browseScreen
import nexus.kekkon.soto.feature.home.browse.navigation.navigateToBrowse
import nexus.kekkon.soto.feature.home.library.navigation.LibraryDestination
import nexus.kekkon.soto.feature.home.library.navigation.libraryScreen
import nexus.kekkon.soto.feature.home.library.navigation.navigateToLibrary
import nexus.kekkon.soto.feature.home.recent.navigation.navigateToRecent
import nexus.kekkon.soto.feature.home.recent.navigation.recentScreen

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    this.navigate(
        HomeDestination,
        navOptions
    )
}

fun NavController.navigateTo(route: HomeDestination.Route, navOptions: NavOptions? = null) {
    when (route) {
        HomeDestination.Route.LIBRARY -> navigateToLibrary(navOptions)
        HomeDestination.Route.RECENT -> navigateToRecent(navOptions)
        HomeDestination.Route.BROWSE -> navigateToBrowse(navOptions)
    }
}

fun NavGraphBuilder.homeNavigation() {
    navigation<HomeDestination>(startDestination = LibraryDestination) {
        libraryScreen()
        recentScreen()
        browseScreen()
    }
}
