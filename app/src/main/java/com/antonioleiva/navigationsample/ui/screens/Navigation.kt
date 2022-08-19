package com.antonioleiva.navigationsample.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.antonioleiva.navigationsample.ui.screens.detail.Detail
import com.antonioleiva.navigationsample.ui.screens.home.Home

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            Home(onNavigate = { navController.navigate("detail") })
        }
        composable("detail") {
            Detail(onUpclick = { navController.popBackStack() })
        }
    }
}