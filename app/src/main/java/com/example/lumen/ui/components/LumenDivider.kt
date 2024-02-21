package com.example.lumen.ui.components

import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.lumen.ui.theme.MediumAquamarine

@Composable
fun LumenDivider(modifier: Modifier = Modifier) {
    Divider(modifier = modifier, color = MediumAquamarine)
}