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

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import nexus.kekkon.soto.R
import nexus.kekkon.soto.core.ui.icon.SotoIcons
import nexus.kekkon.soto.feature.home.navigation.HomeDestination
import nexus.kekkon.soto.feature.home.ui.HomeBottomBar
import nexus.kekkon.soto.feature.home.ui.HomeTopBar
import nexus.kekkon.soto.feature.settings.R as settingsR
import nexus.kekkon.soto.navigation.SotoNavHost
import nexus.kekkon.soto.navigation.TopLevelDestination
import nexus.kekkon.soto.navigation.hasRoute

@Composable
fun SotoApp(
    appState: SotoAppState = rememberSotoAppState(),
) {
    val currentDestination = appState.currentDestination
    val topLevelDestination = currentDestination.findTopLevel()

    @Composable
    fun navHost() = SotoNavHost(appState)

    Scaffold(
        topBar = {
            when (topLevelDestination) {
                TopLevelDestination.Route.HOME -> HomeTopBar(
                    appName = stringResource(id = R.string.app_name),
                    actions = {
                        IconButton(
                            onClick = { appState.navigateTo(TopLevelDestination.Route.SETTINGS) },
                        ) {
                            Icon(
                                imageVector = SotoIcons.Settings,
                                contentDescription = stringResource(id = settingsR.string.settings),
                            )
                        }
                    },
                )

                else -> {}
            }
        },
        bottomBar = {
            when (topLevelDestination) {
                TopLevelDestination.Route.HOME -> HomeBottomBar(
                    destinations = HomeDestination.Route.entries,
                    onNavigateTo = appState::navigateTo,
                    currentDestination = currentDestination,
                )

                else -> {}
            }
        },
    ) { innerPadding ->
        Row(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .consumeWindowInsets(innerPadding),
        ) {
            navHost()
        }
    }
}

private fun NavDestination?.findTopLevel(): TopLevelDestination.Route? =
    TopLevelDestination.Route.entries.find { destination ->
        this.hasHierarchyRoute(destination)
    }

private fun NavDestination?.hasHierarchyRoute(route: TopLevelDestination.Route): Boolean =
    this?.hierarchy?.any {
        it.hasRoute(route)
    } ?: false
