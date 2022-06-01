package com.example.ss_team2.presentation.profile

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ss_team2.domain.model.Post
import com.example.ss_team2.domain.model.tempUserPostData

@Composable
fun UserPostCardList(
    tabPage: Int,
    userPostList: List<Post>,
    modifier: Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 10.dp, horizontal = 20.dp),
        modifier = modifier
            .fillMaxWidth()
    ) {
        repeat(4){
            items(tempUserPostData){ item ->
                UserPostCard(
                    type = item.type,
                    image = item.image,
                    what = item.what,
                    where = item.where,
                    modifier = Modifier
                )
//                if (tabPage == 0) {
//                    if (!item.done) {
//                        UserPostCard(
//                            type = item.type,
//                            image = item.image,
//                            what = item.what,
//                            where = item.where,
//                            modifier = Modifier
//                        )
//                    }
//                }else {
//                    if (item.done) {
//                        UserPostCard(
//                            type = item.type,
//                            image = item.image,
//                            what = item.what,
//                            where = item.where,
//                            modifier = Modifier
//                        )
//                    }
//                }
            }
        }
    }
}