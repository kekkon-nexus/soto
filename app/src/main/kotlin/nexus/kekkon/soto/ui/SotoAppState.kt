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

package nexus.kekkon.soto.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.util.trace
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import nexus.kekkon.soto.feature.home.navigation.HomeDestination
import nexus.kekkon.soto.feature.home.navigation.navigateTo
import nexus.kekkon.soto.feature.home.navigation.navigateToHome
import nexus.kekkon.soto.feature.settings.navigation.navigateToSettings
import nexus.kekkon.soto.navigation.TopLevelDestination

@Composable
fun rememberSotoAppState(
    navController: NavHostController = rememberNavController(),
): SotoAppState {
    return remember {
        SotoAppState(
            navController,
        )
    }
}

@Stable
class SotoAppState(
    val navController: NavHostController,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val topLevelNavOption
        get() = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }

    fun navigateTo(destination: TopLevelDestination.Route) {
        trace(destination.toString()) {
            when (destination) {
                TopLevelDestination.Route.HOME -> navController.navigateToHome(topLevelNavOption)
                TopLevelDestination.Route.SETTINGS -> navController.navigateToSettings(topLevelNavOption)
            }
        }
    }

    fun navigateTo(destination: HomeDestination.Route) {
        trace(destination.toString()) {
            navController.navigateTo(destination, topLevelNavOption)
        }
    }
}
