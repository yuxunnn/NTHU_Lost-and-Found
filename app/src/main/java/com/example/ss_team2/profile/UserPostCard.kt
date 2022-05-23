package com.example.ss_team2.profile

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun UserPostCard(
    type: Int,
    @DrawableRes image: Int,
    what: List<String>,
    where: List<String>,
    modifier: Modifier
) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable {}
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(72.dp)
            )
            PostInfo(
                text = "What",
                tags = what,
                modifier = Modifier
                    .offset(x = 12.dp)
                    .width(30.dp)
            )
            PostInfo(
                text = "Where",
                tags = where,
                modifier = Modifier.offset(x = 60.dp)
            )
        }
    }
    PostTypeHint(
        type = type,
        modifier = modifier
            .offset(x = (-10).dp, y = (-82).dp)
            .size(20.dp)
    )
}