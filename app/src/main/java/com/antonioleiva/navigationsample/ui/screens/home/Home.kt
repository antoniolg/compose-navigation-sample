package com.antonioleiva.navigationsample.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.antonioleiva.navigationsample.ui.screens.Screen

@Composable
fun Home(onNavigate: () -> Unit) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Navigation Sample") }) }
    ) { padding ->
        Screen(
            modifier = Modifier.padding(padding)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Button(onClick = onNavigate) {
                    Text("Navigate to Detail")
                }
            }
        }
    }
}