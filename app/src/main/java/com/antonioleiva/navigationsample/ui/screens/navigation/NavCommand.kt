package com.antonioleiva.navigationsample.ui.screens.navigation

import androidx.navigation.navArgument

sealed class NavCommand(
    val feature: Feature,
    val subRoute: String,
    val navArgs: List<NavArg> = emptyList()
) {
    class Home(feature: Feature) : NavCommand(feature, "home")
    class Detail(feature: Feature) : NavCommand(feature, "detail", listOf(NavArg.ItemId))

    val route = run {
        val argValues = navArgs.map { "{${it.key}}" }
        listOf(feature.route)
            .plus(subRoute)
            .plus(argValues)
            .joinToString("/")
    }

    val args = navArgs.map {
        navArgument(it.key) { type = it.navType }
    }
}