package com.example.ss_team2.homepage

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomepageMainButton(
    type: Int,
    onClick: () -> Unit
) {
    val color: Color = when (type) {
        1 -> Color.Red
        2 -> Color.Green
        else -> Color.Cyan
    }
    val text: String = when (type) {
        1 -> "遺失"
        2 -> "撿到"
        else -> "前往地圖"
    }

    Button(
        onClick = onClick,
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        modifier = Modifier
            .width(200.dp)
            .height(92.dp)
            .clip(CutCornerShape(size = 4.dp))
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )
    }
}