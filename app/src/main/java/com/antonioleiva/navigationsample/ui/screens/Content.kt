package com.antonioleiva.navigationsample.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun Content(text: String) {
    Box(contentAlignment = Alignment.Center) {
        Text(
            text = text,
            style = MaterialTheme.typography.h4
        )
    }
}