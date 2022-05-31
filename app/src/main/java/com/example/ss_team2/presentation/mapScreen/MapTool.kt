package com.example.ss_team2.presentation.mapScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MapTool(
    image: Int
) {
    Image(
        painter = painterResource(id = image),
        contentScale = ContentScale.Crop,
        contentDescription = null,
        modifier = Modifier.height(80.dp).width(80.dp)
    )
}