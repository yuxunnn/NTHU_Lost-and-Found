package com.example.ss_team2.presentation.ui.profile

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ss_team2.presentation.viewModel.PostViewModel

@Composable
fun UserPostCardList(
    tabPage: Int,
    postViewModel: PostViewModel,
    modifier: Modifier,
    navController: NavController
) {

    val posts by postViewModel.posts.collectAsState()

    LazyColumn(
        contentPadding = PaddingValues(vertical = 10.dp, horizontal = 20.dp),
        modifier = modifier
            .fillMaxWidth()
    ) {
        items(posts) { item ->
            if (tabPage == 0) {
                if (!item.hasDone) {
                    UserPostCard(
                        what = item.itemType,
                        where = item.location,
                        type = item.postType,
                        modifier = Modifier,
                        navController = navController
                    )
                }
            } else {
                if (item.hasDone) {
                    UserPostCard(
                        what = item.itemType,
                        where = item.location,
                        type = item.postType,
                        modifier = Modifier,
                        navController = navController
                    )
                }
            }
        }
    }
}