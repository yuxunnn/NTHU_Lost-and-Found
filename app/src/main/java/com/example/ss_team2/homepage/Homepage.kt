package com.example.ss_team2.homepage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ss_team2.ui.theme.SSteam2Theme


@Composable
fun SchoolFlag(
    school: Int
) {
    val color: Color = when (school) {
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

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(12.dp)
            .height(16.dp)
            .clip(CutCornerShape(bottomStart = 6.dp, bottomEnd = 6.dp))
            .background(
                color = color,
                shape = RectangleShape
            )
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 8.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.offset(y = (-2).dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun SchoolFlagPreview() {
    SSteam2Theme {
        Column(
        ) {
            SchoolFlag(school = 1)
            SchoolFlag(school = 2)
            SchoolFlag(school = 3)
            SchoolFlag(school = 4)
        }
    }
}
