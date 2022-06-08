package com.example.ss_team2.presentation.ui.utility

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ss_team2.ui.theme.TextGray

@Composable
fun TopBar(
    leftButton: @Composable (() -> Unit),
    text: String,
    rightButton: @Composable (() -> Unit)
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        leftButton()
        Text(
            text = text,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier,
            color = TextGray
        )
        rightButton()
    }
}

@Composable
fun TopBarButton(
    imageVector: ImageVector,
    onClick: () -> Unit
) {
    Icon(
        imageVector = imageVector,
        contentDescription = null,
        tint = TextGray,
        modifier = Modifier
            .size(40.dp)
            .clickable(
                onClick = onClick
            )
    )
}
