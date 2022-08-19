package com.antonioleiva.navigationsample.ui.screens.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.antonioleiva.navigationsample.ui.screens.Content
import com.antonioleiva.navigationsample.ui.screens.Screen

@Composable
fun Detail(onUpclick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Detail") },
                navigationIcon = {
                    IconButton(onClick = onUpclick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Go Back"
                        )
                    }
                })
        }
    ) { padding ->
        Screen(modifier = Modifier.padding(padding)) {
            Box(contentAlignment = Alignment.Center) {
                Content(text = "Detail")
            }
        }
    }
}