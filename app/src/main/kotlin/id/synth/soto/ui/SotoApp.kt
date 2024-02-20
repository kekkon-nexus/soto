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

package id.synth.soto.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import id.synth.soto.R
import id.synth.soto.feature.home.ui.HomeScaffold
import id.synth.soto.navigation.SotoNavHost
import id.synth.soto.navigation.TopLevelDestination

@Composable
fun SotoApp(
    appState: SotoAppState = rememberSotoAppState(),
) {
    val currentDestination = appState.currentDestination

    @Composable
    fun navHost() = SotoNavHost(appState)

    when (currentDestination.asTopLevel()) {
        TopLevelDestination.HOME -> HomeScaffold(
            appName = stringResource(id = R.string.app_name),
            onNavigateTo = appState::navigateToHome,
            currentDestination = currentDestination,
        ) {
            navHost()
        }

        null -> navHost()
    }
}

private fun NavDestination?.asTopLevel(): TopLevelDestination? =
    TopLevelDestination.entries.find { destination ->
        this.isInHierarchy(destination)
    }

private fun NavDestination?.isInHierarchy(destination: TopLevelDestination): Boolean =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false
