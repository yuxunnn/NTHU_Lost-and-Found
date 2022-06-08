package com.example.ss_team2.presentation.ui.postList

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.ss_team2.R
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ss_team2.data.data_source.Post
import com.example.ss_team2.presentation.ui.utility.WhatAndWhereColElement

@Composable
fun PostPreviewElement(
    post: Post,
    onClick: () -> Unit,
) {
    OutlinedButton(
        modifier = Modifier
            .width(360.dp)
            .height(140.dp),
        shape = RoundedCornerShape(12),
        onClick = onClick,
        border = BorderStroke(1.dp, Color(0x66, 0x70, 0x80))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(36.dp),
            modifier = Modifier.width(300.dp).fillMaxHeight()
        ) {
            Image(
                painter = painterResource(R.drawable.umbrella1),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(RectangleShape)
            )
            WhatAndWhereColElement(post.itemType, post.location, modifier = Modifier.fillMaxHeight())
            Text(
                text = post.postDescribe!!,
                fontSize = 16.sp,
                color = Color(66, 70, 80),
                fontWeight = FontWeight.Bold
            )
        }
        if (post.postType != "Lost") {
            Text(
                text = "+${post.rewardCoin}",
                fontSize = 12.sp,
                modifier = Modifier.align(Alignment.Bottom)
            )
        }
    }
}