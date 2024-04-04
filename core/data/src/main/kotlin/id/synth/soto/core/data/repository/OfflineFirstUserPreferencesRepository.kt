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

package id.synth.soto.core.data.repository

import id.synth.soto.core.datastore.UserPreferencesProtoDataStore
import id.synth.soto.model.data.DarkThemeConfig
import id.synth.soto.model.data.UserPreferences
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class OfflineFirstUserPreferencesRepository @Inject constructor(
    private val dataStore: UserPreferencesProtoDataStore,
) : UserPreferencesRepository {
    override val userPreferences: Flow<UserPreferences> =
        dataStore.userPreferences

    override suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig) {
        dataStore.setDarkThemeConfig(darkThemeConfig)
    }

    override suspend fun setDynamicColorPreference(useDynamicColor: Boolean) {
        dataStore.setDynamicColorPreference(useDynamicColor)
    }
}
