package com.antonioleiva.navigationsample.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.antonioleiva.navigationsample.ui.screens.Content

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Feature.HOME.route) {
        BottomNavItem.values().forEach { navDestination ->
            val homeNavCommand = NavCommand.Home(navDestination.feature)
            val detailNavCommand = NavCommand.Detail(navDestination.feature)

            navigation(
                startDestination = homeNavCommand.route,
                route = navDestination.feature.route
            ) {
                composable(
                    route = homeNavCommand.route,
                    arguments = homeNavCommand.args
                ) {
                    Content(text = stringResource(navDestination.title), onClick = {
                        navController.navigate(
                            "$navDestination/detail/${System.currentTimeMillis()}"
                        )
                    })
                }
                composable(
                    route = detailNavCommand.route,
                    arguments = detailNavCommand.args
                ) { backStackEntry ->
                    val text = backStackEntry.arguments?.getLong(NavArg.ItemId.key) ?: ""
                    Content(text = "$navDestination Detail: $text")
                }
            }
        }
    }
}