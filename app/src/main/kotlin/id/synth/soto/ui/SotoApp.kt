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

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import id.synth.soto.R
import id.synth.soto.navigation.SotoNavHost
import id.synth.soto.navigation.TopLevelDestination

@Composable
fun SotoApp(
    appState: SotoAppState = rememberSotoAppState(),
) {
    Scaffold(
        topBar = { SotoTopBar() },
        bottomBar = {
            SotoBottomBar(
                destination = TopLevelDestination.entries.toList(),
                onNavigateTo = appState::navigateTo,
                currentDestination = appState.currentDestination,
            )
        },
    ) { innerPadding ->
        Row(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .consumeWindowInsets(innerPadding),
        ) {
            SotoNavHost(appState)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun SotoTopBar() {
    TopAppBar(
        title = { Text(stringResource(id = R.string.app_name)) },
    )
}

@Composable
fun SotoBottomBar(
    destination: List<TopLevelDestination>,
    onNavigateTo: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        destination.forEach { destination ->
            val selected = currentDestination.isInHierarchy(destination)
            NavigationBarItem(
                selected = selected,
                onClick = { onNavigateTo(destination) },
                icon = {
                    if (selected) Icon(
                        imageVector = destination.iconSelected,
                        contentDescription = null,
                    )
                    else Icon(
                        imageVector = destination.iconUnselected,
                        contentDescription = null,
                    )
                },
                label = { Text(stringResource(destination.textId)) },
            )
        }
    }
}

private fun NavDestination?.isInHierarchy(destination: TopLevelDestination): Boolean =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false
