package com.antonioleiva.navigationsample.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.antonioleiva.navigationsample.Screen

@Preview
@Composable
fun Home() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Navigation Sample") }) }
    ) { padding ->
        Screen(
            modifier = Modifier.padding(padding)
        ) {
            Content("Home")
        }
    }
}