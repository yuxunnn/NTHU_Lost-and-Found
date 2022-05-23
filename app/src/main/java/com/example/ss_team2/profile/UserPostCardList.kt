package com.example.ss_team2.profile

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UserPostCardList(UserPostData: List<Post>, modifier: Modifier) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 10.dp, horizontal = 20.dp),
        modifier = modifier
            .fillMaxWidth()
    ) {
        items(UserPostData) { item ->
            UserPostCard(
                type = item.type,
                image = item.image,
                what = item.what,
                where = item.where,
                modifier = Modifier
            )
        }
    }
}