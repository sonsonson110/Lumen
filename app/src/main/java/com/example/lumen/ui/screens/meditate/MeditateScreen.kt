package com.example.lumen.ui.screens.meditate

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MeditateScreen(modifier: Modifier) {
    Scaffold(modifier = modifier) { innerPadding ->
        Box(Modifier.padding(innerPadding)) {
            Text(text = "MeditateScreen")
        }
    }
}