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

package nexus.kekkon.soto.core.ui.theme

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocal
import androidx.compose.ui.graphics.Color
import dev.tclement.fonticons.IconFont
import dev.tclement.fonticons.ProvideIconParameters
import dev.tclement.fonticons.symbols.outlined.rememberOutlinedMaterialSymbolsFont

val SotoTypography = Typography()

@Composable
fun SotoIconParameters(
    iconFont: IconFont = rememberOutlinedMaterialSymbolsFont(),
    tintProvider: CompositionLocal<Color> = LocalContentColor,
    content: @Composable () -> Unit,
) {
    ProvideIconParameters(
        iconFont = iconFont,
        tintProvider = tintProvider,
        content = content,
    )
}
