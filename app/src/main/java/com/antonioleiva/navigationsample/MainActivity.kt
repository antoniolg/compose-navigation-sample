package com.antonioleiva.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.antonioleiva.navigationsample.ui.Content
import com.antonioleiva.navigationsample.ui.Home
import com.antonioleiva.navigationsample.ui.theme.NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavigationSampleTheme {
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        Home(onNavigate = { navController.navigate("detail") })
                    }
                    composable("detail") {
                        Content(text = "Detail")
                    }
                }
            }
        }
    }
}

@Composable
fun Screen(modifier: Modifier, content: @Composable () -> Unit) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.background,
        content = content
    )
}