package com.example.ss_team2.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.ss_team2.ui.theme.FindHint
import com.example.ss_team2.ui.theme.FindHintDark
import com.example.ss_team2.ui.theme.LostHint
import com.example.ss_team2.ui.theme.LostHintDark

@Composable
fun PostTypeHint(
    type: Int,
    modifier: Modifier
) {
    val color: Color =
        if (MaterialTheme.colors.isLight) {
            if (type == 1) FindHint else LostHint
        } else {
            if (type == 1) FindHintDark else LostHintDark
        }

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
