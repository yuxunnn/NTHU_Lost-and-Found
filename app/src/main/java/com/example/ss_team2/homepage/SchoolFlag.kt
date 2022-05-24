package com.example.ss_team2.homepage

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
fun SchoolFlag(
    school: Int,
    currentSchool: Int,
    onClick: () -> Unit,
    modifier: Modifier
) {
    val color: Color = if (school != currentSchool) Color.LightGray
    else when (school) {
        1 -> Color.Magenta
        2 -> Color.Yellow
        3 -> Color.Cyan
        else -> Color.Blue
    }
    val text: String = when (school) {
        1 -> "清"
        2 -> "交"
        3 -> "台"
        else -> "政"
    }

    Button(
        onClick = onClick,
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        modifier = modifier
            .width(60.dp)
            .height(80.dp)
            .clip(CutCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp))
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.offset(y = (-10).dp)
        )
    }
}