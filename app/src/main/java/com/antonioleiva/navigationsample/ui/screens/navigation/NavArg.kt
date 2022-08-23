package com.antonioleiva.navigationsample.ui.screens.navigation

import androidx.navigation.NavType

enum class NavArg(val key: String, val navType: NavType<*>) {
    ItemId("itemId", NavType.LongType)
}