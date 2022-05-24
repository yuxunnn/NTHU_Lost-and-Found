package com.example.ss_team2.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ChangeListButton(
    onNewPost: Boolean,
    onClickNew: () -> Unit,
    onClickOld: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
    ) {
        ListButton(
            onState = onNewPost,
            imageVector = Icons.Default.List,
            onClick = onClickNew,
            modifier = Modifier.weight(1f)
        )
        ListButton(
            onState = !onNewPost,
            imageVector = Icons.Default.Star,
            onClick = onClickOld,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun ListButton(
    onState: Boolean,
    imageVector: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier
){
    Button(
        onClick = onClick,
        colors = ButtonDefaults
            .buttonColors(
                backgroundColor = MaterialTheme.colors.background,
                contentColor = if (onState) MaterialTheme.colors.primary else Color.LightGray
            ),
        contentPadding = PaddingValues(all = 0.dp),
        shape = RectangleShape,
        modifier = modifier
            .height(48.dp)
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            modifier = Modifier.size(36.dp)
        )
    }
}