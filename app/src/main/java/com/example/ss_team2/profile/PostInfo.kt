package com.example.ss_team2.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PostInfo(
    text: String,
    tags: List<String>,
    modifier: Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = text,
            style = MaterialTheme.typography.h6,
            fontSize = 8.sp,
            modifier = Modifier
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            items(tags) { location ->
                Text(
                    text = location,
                    style = MaterialTheme.typography.h6,
                    fontSize = 12.sp,
                )
            }
        }
    }
}