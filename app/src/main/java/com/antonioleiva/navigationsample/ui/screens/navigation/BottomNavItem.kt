package com.antonioleiva.navigationsample.ui.screens.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.antonioleiva.navigationsample.R

enum class BottomNavItem(val icon: ImageVector, val feature: Feature, @StringRes val title: Int) {
    HOME(Icons.Default.Home, Feature.HOME, R.string.home),
    SEARCH(Icons.Default.Search, Feature.SEARCH, R.string.search),
    FAVORITE(Icons.Default.Favorite, Feature.FAVORITE, R.string.favorite),
    SETTINGS(Icons.Default.Settings, Feature.SETTINGS, R.string.settings)
}