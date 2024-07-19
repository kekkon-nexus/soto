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

package nexus.kekkon.soto.core.ui.icon

import android.provider.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import dev.tclement.compose.symbols.Symbols
import dev.tclement.compose.symbols.outlined.filled.g0.w400.BrowseGallery
import dev.tclement.compose.symbols.outlined.filled.g0.w400.LibraryAdd
import dev.tclement.compose.symbols.outlined.filled.g0.w400.LocalLibrary
import dev.tclement.compose.symbols.outlined.g0.w400.BrowseGallery
import dev.tclement.compose.symbols.outlined.g0.w400.LibraryAdd
import dev.tclement.compose.symbols.outlined.g0.w400.LocalLibrary
import dev.tclement.compose.symbols.outlined.g0.w400.Settings
import dev.tclement.fonticons.FontIcon
import dev.tclement.fonticons.symbols.BrowseGallery
import dev.tclement.fonticons.symbols.LibraryAdd
import dev.tclement.fonticons.symbols.LocalLibrary
import dev.tclement.fonticons.symbols.MaterialSymbols
import dev.tclement.fonticons.symbols.Settings
import dev.tclement.fonticons.symbols.outlined.rememberOutlinedMaterialSymbolsFont

/**
 * Soto icons. Material icons are [ImageVector]s.
 */
object SotoIcons {
    val Browse = Symbols.Outlined.Grade0.Weight400.LibraryAdd
    val BrowseFilled = Symbols.Outlined.Grade0.Weight400.Filled.LibraryAdd
    val Library = Symbols.Outlined.Grade0.Weight400.LocalLibrary
    val LibraryFilled = Symbols.Outlined.Grade0.Weight400.Filled.LocalLibrary
    val Recent = Symbols.Outlined.Grade0.Weight400.BrowseGallery
    val RecentFilled = Symbols.Outlined.Grade0.Weight400.Filled.BrowseGallery
    val Settings = Symbols.Outlined.Grade0.Weight400.Settings
}

object SotoFontIcons {
    @Composable
    private fun rememberNav() = rememberOutlinedMaterialSymbolsFont(fill = false)
    @Composable
    private fun rememberNavFill() = rememberOutlinedMaterialSymbolsFont(fill = true)

    @Composable
    fun Browse(contentDescription: String? = null) {
        FontIcon(
            icon = MaterialSymbols.LibraryAdd,
            contentDescription = contentDescription,
            iconFont = rememberNav(),
        )
    }
    @Composable
    fun BrowseFill(contentDescription: String? = null) {
        FontIcon(
            icon = MaterialSymbols.LibraryAdd,
            contentDescription = contentDescription,
            iconFont = rememberNavFill(),
        )
    }
    @Composable
    fun Library(contentDescription: String? = null) {
        FontIcon(
            icon = MaterialSymbols.LocalLibrary,
            contentDescription = contentDescription,
            iconFont = rememberNav(),
        )
    }
    @Composable
    fun LibraryFill(contentDescription: String? = null) {
        FontIcon(
            icon = MaterialSymbols.LocalLibrary,
            contentDescription = contentDescription,
            iconFont = rememberNavFill(),
        )
    }
    @Composable
    fun Recent(contentDescription: String? = null) {
        FontIcon(
            icon = MaterialSymbols.BrowseGallery,
            contentDescription = contentDescription,
            iconFont = rememberNav(),
        )
    }
    @Composable
    fun RecentFill(contentDescription: String? = null) {
        FontIcon(
            icon = MaterialSymbols.BrowseGallery,
            contentDescription = contentDescription,
            iconFont = rememberNavFill(),
        )
    }

    @Composable
    fun Settings(contentDescription: String? = null) {
        FontIcon(
            icon = MaterialSymbols.Settings,
            contentDescription = contentDescription,
        )
    }
}
