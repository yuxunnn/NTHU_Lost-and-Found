package com.example.ss_team2.presentation.ui.postList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WhatAndWhereColElement(
    what: String,
    where: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "What",
            modifier = Modifier.padding(4.dp),
            fontSize = 10.sp,
            color = Color(66, 70, 80),
            fontWeight = FontWeight.Bold
        )
        Surface(
            modifier = modifier.paddingFromBaseline(top = 0.dp, bottom = 20.dp),
            shape = MaterialTheme.shapes.small,
            color = Color(66, 70, 80)
        ) {
            Text(
                text = what,
                modifier = Modifier.padding(6.dp),
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Text(
            text = "Where",
            modifier = Modifier.padding(4.dp),
            fontSize = 10.sp,
            color = Color(66, 70, 80),
            fontWeight = FontWeight.Bold
        )
        Surface(
            modifier = modifier,
            shape = MaterialTheme.shapes.small,
            color = Color(66, 70, 80)
        ) {
            Text(
                text = where,
                modifier = Modifier.padding(6.dp),
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}