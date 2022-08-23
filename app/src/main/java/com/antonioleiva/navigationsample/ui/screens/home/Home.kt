package com.antonioleiva.navigationsample.ui.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.antonioleiva.navigationsample.ui.screens.Screen
import com.antonioleiva.navigationsample.ui.screens.navigation.BottomNavItem
import com.antonioleiva.navigationsample.ui.screens.navigation.Navigation

@Composable
fun Home() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Navigation Sample") }) },
        bottomBar = {
            BottomNavigation {
                BottomNavItem.values().forEach { navItem ->
                    val navItemTitle = stringResource(navItem.title)
                    BottomNavigationItem(
                        selected = navItem.ordinal == 0,
                        onClick = {
                            navController.navigate(navItem.feature.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(navItem.icon, navItemTitle) },
                        label = { Text(navItemTitle) })
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