package com.example.ss_team2.profile

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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Composable
fun ChangeListButton() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
    ) {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults
                .buttonColors(
                    backgroundColor = MaterialTheme.colors.background,
                    contentColor = MaterialTheme.colors.onBackground
                ),
            contentPadding = PaddingValues(all = 0.dp),
            shape = RectangleShape,
            modifier = Modifier
                .weight(1f)
                .height(48.dp)
        ) {
            Icon(
                imageVector = Icons.Default.List,
                contentDescription = null,
                modifier = Modifier.size(36.dp)
            )
        }

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults
                .buttonColors(
                    backgroundColor = MaterialTheme.colors.background,
                    contentColor = MaterialTheme.colors.onBackground
                ),
            contentPadding = PaddingValues(all = 0.dp),
            shape = RectangleShape,
            modifier = Modifier
                .weight(1f)
                .height(48.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                modifier = Modifier.size(36.dp)
            )
        }
    }
}