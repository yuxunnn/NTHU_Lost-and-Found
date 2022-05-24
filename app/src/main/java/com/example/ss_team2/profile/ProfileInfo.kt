package com.example.ss_team2.profile

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ProfileInfo(
    @DrawableRes image: Int,
    schoolName: String,
    toolAmount: Int,
    point: Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.padding(top = 20.dp)
    ) {
        Image(
            painter = painterResource(id = image),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .width(90.dp)
                .height(90.dp)
        )
        Text(
            text = schoolName
        )
    }

    Row(
        horizontalArrangement = Arrangement.spacedBy(80.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 32.dp, bottom = 12.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(80.dp)
        ) {
            Text(
                text = toolAmount.toString()
            )
            Text(
                text = "擁有道具"
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(80.dp)
        ) {
            Text(
                text = point.toString()
            )
            Text(
                text = "積分"
            )
        }
    }

}