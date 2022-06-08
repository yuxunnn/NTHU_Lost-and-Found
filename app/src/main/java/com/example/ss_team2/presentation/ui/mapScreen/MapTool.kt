package com.example.ss_team2.presentation.ui.mapScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ss_team2.ui.theme.Iris

@Composable
fun MapTool(
    image: Int,
    amount: Int,
    selected: Boolean,
    onClick: () -> Unit
) {

    val border = if (selected) Iris else Color.Transparent

    Box(
        modifier = Modifier
            .size(80.dp)
            .clickable(
                enabled = amount != 0,
                onClick = onClick
            )
            .border(BorderStroke(width = 3.dp, color = border))
    ) {
        Image(
            painter = painterResource(id = image),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier.size(68.dp).align(Alignment.CenterStart).padding(all = 4.dp),
            colorFilter = ColorFilter.colorMatrix(
                colorMatrix = ColorMatrix().apply {
                    setToSaturation(if (amount == 0) 0f else 1f)
                }
            )
        )

        Text(
            text = "$amount",
            color = Iris,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(alignment = Alignment.BottomEnd)
                .padding(all = 4.dp)
        )
    }
}