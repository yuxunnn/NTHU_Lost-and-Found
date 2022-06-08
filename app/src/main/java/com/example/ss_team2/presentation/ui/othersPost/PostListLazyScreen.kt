package com.example.ss_team2.presentation.ui.othersPost

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ss_team2.R
import com.example.ss_team2.presentation.viewModel.HelperViewModel
import com.example.ss_team2.presentation.viewModel.PostViewModel
import com.example.ss_team2.presentation.viewModel.UserViewModel

@Composable
fun PostListLazyScreen(
    modifier: Modifier = Modifier,
    helperViewModel: HelperViewModel,
    userViewModel: UserViewModel,
    postViewModel: PostViewModel
) {

    val post by postViewModel.post.collectAsState()
    val otherUser by userViewModel.otherUser.collectAsState()
    val helpers by helperViewModel.helpers.collectAsState()

    LazyColumn(
        modifier = Modifier
    ) {
        item { UserCard(userName = otherUser.userName, drawable = R.drawable.defaultpicture) }
        item {
            PostItemCard(
                postViewModel = postViewModel
            )
        }
        item { Spacer(modifier = Modifier.height(10.dp)) }
        items(helpers) { item ->
            UserCard(userName = item.helperName, drawable = R.drawable.defaultpicture)
        }
    }
}