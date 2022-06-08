package com.example.ss_team2.presentation.ui.postList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.viewModel.PostViewModel

@Composable
fun PostListLazyScreen(
    postType: String,
    postViewModel: PostViewModel,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val posts by postViewModel.posts.collectAsState()

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy((8.dp))
    ) {
        items(posts) { post ->
            if (post.postType == postType) {
                PostPreviewElement(
                    post = post,
                    onClick = {
                        postViewModel.getPostById(postId = post.postId)
                        navController.navigate(route = Screen.OthersLostList.route)
                    }
                )
            }
        }
    }
}