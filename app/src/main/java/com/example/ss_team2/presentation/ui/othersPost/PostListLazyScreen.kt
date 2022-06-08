package com.example.ss_team2.presentation.ui.othersPost

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ss_team2.presentation.viewModel.PostViewModel
import com.example.ss_team2.presentation.viewModel.UserViewModel

@Composable
fun PostListLazyScreen(
    modifier: Modifier = Modifier,
    userViewModel: UserViewModel,
    postViewModel: PostViewModel
) {

    val post by postViewModel.post.collectAsState()

    LazyColumn(
        modifier = Modifier
    ) {
//        item { UserCardWithMoney(str = str, drawable = userdrawable, time = time, money = money) }
        item {
            PostItemCard(
                postViewModel = postViewModel
            )
        }
        item { Spacer(modifier = Modifier.height(10.dp)) }
//        items(TestData) { item ->
//            UserCard(str = item.text, drawable = item.drawable, time = 20)
//        }
    }
}