package com.example.ss_team2.presentation.ui.othersPost

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ss_team2.R
import com.example.ss_team2.presentation.ui.utility.WhatAndWhereColElement
import com.example.ss_team2.presentation.viewModel.PostViewModel
import com.example.ss_team2.ui.theme.TextGray

@Composable
fun PostItemCard(
    modifier: Modifier = Modifier,
    postViewModel: PostViewModel
) {

    val post by postViewModel.post.collectAsState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .background(Color(220, 220, 220)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.defaultpicture),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxHeight()
                .width(200.dp)
                .clip(RectangleShape)
        )
        Column(modifier = Modifier) {
            WhatAndWhereColElement(
                what = post.itemType,
                where = post.location,
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 12.dp, bottom = 24.dp)
            )
            Text(
                text = post.postDescribe!!,
                color = TextGray,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.weight(1f)
            )
        }

    }
}