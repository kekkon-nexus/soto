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
import androidx.compose.ui.graphics.vector.ImageVector
import nexus.kekkon.soto.core.ui.icon.SotoIcons
import nexus.kekkon.soto.feature.home.browse.R as browseR
import nexus.kekkon.soto.feature.home.library.R as libraryR
import nexus.kekkon.soto.feature.home.recent.R as recentR

enum class HomeDestination(
    val iconUnselected: ImageVector,
    val iconSelected: ImageVector,
    @StringRes val textId: Int,
) {
    LIBRARY(
        iconUnselected = SotoIcons.Library,
        iconSelected = SotoIcons.LibraryFilled,
        textId = libraryR.string.library,
    ),
    RECENT(
        iconUnselected = SotoIcons.Recent,
        iconSelected = SotoIcons.RecentFilled,
        textId = recentR.string.recent,
    ),
    BROWSE(
        iconUnselected = SotoIcons.Browse,
        iconSelected = SotoIcons.BrowseFilled,
        textId = browseR.string.browse,
    ),
}
