package com.antonioleiva.navigationsample.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.antonioleiva.navigationsample.ui.screens.home.NavItem

@Composable
fun Navigation(navController: NavHostController) {

    val navDestinations = NavItem.values().map { it.title }

    NavHost(navController = navController, startDestination = navDestinations[0]) {
        navDestinations.forEach { navDestination ->
            composable(
                route = navDestination
            ) {
                Content(text = navDestination, onClick = {
                    navController.navigate(
                        "$navDestination/detail/${System.currentTimeMillis()}"
                    )
                })
            }
            composable(
                route = "$navDestination/detail/{text}"
            ) { backStackEntry ->
                val text = backStackEntry.arguments?.getString("text") ?: ""
                Content(text = "$navDestination Detail: $text")
            }
        }
    }
}