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

package nexus.kekkon.soto.core.datastore

import androidx.datastore.core.DataStore
import nexus.kekkon.soto.core.datastore.DarkThemeConfigProto
import nexus.kekkon.soto.core.datastore.UserPreferencesProto
import nexus.kekkon.soto.core.datastore.copy
import nexus.kekkon.soto.core.model.data.DarkThemeConfig
import nexus.kekkon.soto.core.model.data.UserPreferences
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserPreferencesProtoDataStore @Inject constructor(
    private val dataStore: DataStore<UserPreferencesProto>,
) {
    val userPreferences = dataStore.data.map {
        UserPreferences(
            darkThemeConfig = when (it.darkThemeConfig) {
                null,
                DarkThemeConfigProto.UNRECOGNIZED,
                DarkThemeConfigProto.DARK_THEME_CONFIG_FOLLOW_SYSTEM,
                -> DarkThemeConfig.FOLLOW_SYSTEM

                DarkThemeConfigProto.DARK_THEME_CONFIG_LIGHT -> DarkThemeConfig.LIGHT

                DarkThemeConfigProto.DARK_THEME_CONFIG_DARK -> DarkThemeConfig.DARK
            },
            useDynamicColor = !it.disableDynamicColor,
        )
    }

    suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig) {
        dataStore.updateData {
            it.copy {
                this.darkThemeConfig = when (darkThemeConfig) {
                    DarkThemeConfig.FOLLOW_SYSTEM -> DarkThemeConfigProto.DARK_THEME_CONFIG_FOLLOW_SYSTEM
                    DarkThemeConfig.LIGHT -> DarkThemeConfigProto.DARK_THEME_CONFIG_LIGHT
                    DarkThemeConfig.DARK -> DarkThemeConfigProto.DARK_THEME_CONFIG_DARK
                }
            }
        }
    }

    suspend fun setDynamicColorPreference(useDynamicColor: Boolean) {
        dataStore.updateData {
            it.copy { this.disableDynamicColor = !useDynamicColor }
        }
    }
}
