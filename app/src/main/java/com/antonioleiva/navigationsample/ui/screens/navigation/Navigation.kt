package com.antonioleiva.navigationsample.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.antonioleiva.navigationsample.ui.screens.Content

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Feature.HOME.route) {
        BottomNavItem.values().forEach {
            bottomNavigation(it, navController)
        }
    }
}

fun NavGraphBuilder.composable(
    navCommand: NavCommand,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = navCommand.route,
        arguments = navCommand.args,
        content = content
    )
}

fun NavGraphBuilder.bottomNavigation(
    navDestination: BottomNavItem,
    navController: NavHostController
) {
    val homeNavCommand = NavCommand.Home(navDestination.feature)
    val detailNavCommand = NavCommand.Detail(navDestination.feature)

    navigation(
        startDestination = homeNavCommand.route,
        route = navDestination.feature.route
    ) {
        composable(homeNavCommand) {
            Content(text = stringResource(navDestination.title), onClick = {
                navController.navigate(
                    "$navDestination/detail/${System.currentTimeMillis()}"
                )
            })
        }
        composable(detailNavCommand) { backStackEntry ->
            val text = backStackEntry.arguments?.getLong(NavArg.ItemId.key) ?: ""
            Content(text = "$navDestination Detail: $text")
        }
    }
}