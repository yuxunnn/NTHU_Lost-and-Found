package com.example.ss_team2.presentation.ui.utility

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WhatAndWhereRowElement(
    what: String,
    where: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "What",
            modifier = Modifier.padding(4.dp),
            fontSize = 16.sp,
            color = Color(0x66, 0x70, 0x80),
            fontWeight = FontWeight.Bold
        )
        Button(
            modifier = modifier
                .width(80.dp)
                .height(40.dp),
            shape = RoundedCornerShape(15),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.White,
                backgroundColor = Color(0x66, 0x70, 0x80)
            ),
            onClick = {}
        ) {
            Text(
                text = what,
                modifier = Modifier,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.width(60.dp))
        Text(
            text = "Where",
            modifier = Modifier.padding(4.dp),
            fontSize = 16.sp,
            color = Color(0x66, 0x70, 0x80),
            fontWeight = FontWeight.Bold
        )
        Button(
            modifier = modifier
                .width(80.dp)
                .height(40.dp),
            shape = RoundedCornerShape(15),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.White,
                backgroundColor = Color(0x66, 0x70, 0x80)
            ),
            onClick = {}
        ) {
            Text(
                text = where,
                modifier = Modifier,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}