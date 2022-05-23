package com.example.ss_team2.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun PostTypeHint(
    type: Int,
    modifier: Modifier
) {
    val color: Color = if (type == 1) Color.Green else Color.Red
    val text: String = if (type == 1) "撿" else "遺"

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.background(color = color, shape = CircleShape)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 10.sp,
            textAlign = TextAlign.Center
        )
    }
}