package com.example.ss_team2.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ss_team2.R
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.ui.othersPost.PostListLazyScreen
import com.example.ss_team2.presentation.viewModel.HelperViewModel
import com.example.ss_team2.presentation.viewModel.PostViewModel
import com.example.ss_team2.presentation.viewModel.UserViewModel

@Composable
fun MyPostHomeScreen(
    helperViewModel: HelperViewModel,
    userViewModel: UserViewModel,
    postViewModel: PostViewModel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
    ) {
        Text(
            text = stringResource(id = R.string.MyPost),
            fontWeight = FontWeight.Bold,
            color = Color(0x66, 0x70, 0x80),
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 20.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 32.sp
        )
        Divider(
            color = Color(0x66, 0x70, 0x80),
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        PostListLazyScreen(
            helperViewModel = helperViewModel,
            userViewModel = userViewModel,
            postViewModel = postViewModel,
        )
    }
}

@Composable
fun MyPostFinalScreen(
    helperViewModel: HelperViewModel,
    userViewModel: UserViewModel,
    postViewModel: PostViewModel,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(modifier = Modifier.fillMaxSize()) {
        MyPostHomeScreen(
            helperViewModel = helperViewModel,
            userViewModel = userViewModel,
            postViewModel = postViewModel
        )
        Icon(
            Icons.Filled.ArrowBack,
            "",
            modifier = Modifier
                .align(Alignment.TopStart)
                .clickable {
                    navController.popBackStack()
                }
                .padding(16.dp)
        )
    }
}

@Composable
fun MyPostApp(
    helperViewModel: HelperViewModel,
    postViewModel: PostViewModel,
    userViewModel: UserViewModel,
    navController: NavController
) {
    Scaffold(
        bottomBar = {
            MyPostBottomNavigation(
                navController = navController
            )
        }
    ) {
        MyPostFinalScreen(
            helperViewModel = helperViewModel,
            postViewModel = postViewModel,
            userViewModel = userViewModel,
            navController = navController
        )
    }
}

@Composable
private fun MyPostBottomNavigation(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        modifier = modifier
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = null
                )
            },
            label = {
                Text("編輯")
            },
            selected = true,
            onClick = {
                navController.navigate(
                    route = Screen.EditPost.passWhatAndWhereAndUserName(
                        what = "hi",
                        where = "ho",
                        username = "ii"
                    )
                )
            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null
                )
            },
            label = {
                Text("已找回")
            },
            selected = false,
            onClick = {
                navController.navigate(route = Screen.Confirmation.route)
            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null
                )
            },
            label = {
                Text(text = "刪除貼文", color = Color.Red)
            },
            selected = false,
            onClick = {}
        )
    }
}
