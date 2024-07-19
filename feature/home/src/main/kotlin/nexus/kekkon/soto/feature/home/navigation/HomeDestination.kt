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

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import kotlinx.serialization.Serializable
import nexus.kekkon.soto.core.ui.icon.SotoFontIcons
import nexus.kekkon.soto.feature.home.browse.navigation.BrowseDestination
import nexus.kekkon.soto.feature.home.library.navigation.LibraryDestination
import nexus.kekkon.soto.feature.home.recent.navigation.RecentDestination
import nexus.kekkon.soto.feature.home.browse.R as browseR
import nexus.kekkon.soto.feature.home.library.R as libraryR
import nexus.kekkon.soto.feature.home.recent.R as recentR

@Serializable
data object HomeDestination {
    enum class Route(
        val iconUnselected: @Composable () -> Unit,
        val iconSelected: @Composable () -> Unit,
        @StringRes val textId: Int,
    ) {
        LIBRARY(
            iconUnselected = { SotoFontIcons.Library() },
            iconSelected = { SotoFontIcons.LibraryFill() },
            textId = libraryR.string.library,
        ),
        RECENT(
            iconUnselected = { SotoFontIcons.Recent() },
            iconSelected = { SotoFontIcons.RecentFill() },
            textId = recentR.string.recent,
        ),
        BROWSE(
            iconUnselected = { SotoFontIcons.Browse() },
            iconSelected = { SotoFontIcons.BrowseFill() },
            textId = browseR.string.browse,
        ),
    }
}

fun NavDestination.hasRoute(route: HomeDestination.Route): Boolean {
    return when(route) {
        HomeDestination.Route.LIBRARY -> this.hasRoute<LibraryDestination>()
        HomeDestination.Route.RECENT -> this.hasRoute<RecentDestination>()
        HomeDestination.Route.BROWSE -> this.hasRoute<BrowseDestination>()
    }
}
