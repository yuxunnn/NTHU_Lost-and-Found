package com.example.ss_team2.presentation.ui.postList

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.ss_team2.presentation.navigation.Screen

@Composable
fun PostListButton(
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier
) {
    OutlinedButton(
        modifier = modifier
            .size(100.dp)
            .padding(12.dp),
        onClick = onClick,
        shape = CircleShape,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.White,
            backgroundColor = Color(0x78, 0x79, 0xf1)
        )
    ) {
        Icon(icon, "")
    }
}