package com.example.ss_team2

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.ui.LostListLazyScreen
import com.example.ss_team2.presentation.viewModel.PostViewModel
import com.example.ss_team2.presentation.viewModel.UserViewModel
import com.example.ss_team2.ui.theme.SSteam2Theme


@Composable
fun MyPostHomeScreen(
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
                .paddingFromBaseline(top = 16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 32.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Divider(color = Color(0x66, 0x70, 0x80), thickness = 1.dp)
        Spacer(modifier = Modifier.height(16.dp))
        LostListLazyScreen(
            userViewModel = userViewModel,
            postViewModel = postViewModel,
        )
    }
}

@Composable
fun MyPostFinalScreen(
    userViewModel: UserViewModel = viewModel(),
    postViewModel: PostViewModel = viewModel(),
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(modifier = Modifier.fillMaxSize()) {
        MyPostHomeScreen(
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
    navController: NavController
) {
    Scaffold(
        bottomBar = { MyPostBottomNavigation(navController = navController) }
    ) {
        MyPostFinalScreen(
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
                navController.navigate(route = Screen.EditPost.route)
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    SSteam2Theme {
        MyPostApp(navController = rememberNavController())
    }
}