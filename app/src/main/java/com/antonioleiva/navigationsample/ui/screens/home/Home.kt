package com.antonioleiva.navigationsample.ui.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.antonioleiva.navigationsample.ui.screens.Navigation
import com.antonioleiva.navigationsample.ui.screens.Screen

enum class NavItem(val icon: ImageVector, val title: String) {
    HOME(Icons.Default.Home, "Home"),
    SEARCH(Icons.Default.Search, "Search"),
    FAVORITE(Icons.Default.Favorite, "Favorite"),
    SETTINGS(Icons.Default.Settings, "Settings")
}

@Composable
fun Home() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Navigation Sample") }) },
        bottomBar = {
            BottomNavigation {
                NavItem.values().forEach { navItem ->
                    BottomNavigationItem(
                        selected = navItem.ordinal == 0,
                        onClick = {
                            navController.navigate(navItem.title) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(navItem.icon, navItem.title) },
                        label = { Text(navItem.title) })
                }
            }
        }

    ) { padding ->
        Screen(
            modifier = Modifier.padding(padding)
        ) {
            Navigation(navController)
        }
    }
}