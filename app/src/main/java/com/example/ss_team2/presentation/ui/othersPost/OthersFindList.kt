package com.example.ss_team2.presentation.ui.othersPost


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.example.ss_team2.presentation.viewModel.HelperViewModel
import com.example.ss_team2.presentation.viewModel.PostViewModel
import com.example.ss_team2.presentation.viewModel.UserViewModel

@Composable
fun OthersFindListHomeScreen(
    helperViewModel: HelperViewModel,
    userViewModel: UserViewModel,
    postViewModel: PostViewModel,
    modifier: Modifier = Modifier,
) {
    val otherUser by userViewModel.otherUser.collectAsState()

    Column(
        modifier = Modifier
    ) {
        Text(
            text = stringResource(id = R.string.FindList),
            fontWeight = FontWeight.Bold,
            color = Color(0x66, 0x70, 0x80),
            modifier = Modifier
                .paddingFromBaseline(top = 16.dp)
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
            postOwner = otherUser.userName,
            helperViewModel = helperViewModel,
            postViewModel = postViewModel,
        )
    }
}

@Composable
fun OthersFindListFinalScreen(
    helperViewModel: HelperViewModel,
    userViewModel: UserViewModel,
    postViewModel: PostViewModel,
    modifier: Modifier = Modifier,
    navController: NavController
) {

    Box(modifier = Modifier.fillMaxSize()) {
        OthersFindListHomeScreen(
            helperViewModel = helperViewModel,
            postViewModel = postViewModel,
            userViewModel = userViewModel,
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
private fun OthersFindListBottomNavigation(
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
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = null
                )
            },
            label = {
                Text("地圖定位")
            },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null
                )
            },
            label = {
                Text("成功取回")
            },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null
                )
            },
            label = {
                Text("發送訊息")
            },
            selected = false,
            onClick = {
                navController.navigate(route = Screen.ChatRoom.route)
            }
        )
    }
}

@Composable
fun OthersFindListApp(
    helperViewModel: HelperViewModel,
    userViewModel: UserViewModel,
    postViewModel: PostViewModel,
    navController: NavController
) {
    Scaffold(
        bottomBar = { OthersFindListBottomNavigation(navController = navController) }
    ) {
        OthersFindListFinalScreen(
            helperViewModel = helperViewModel,
            userViewModel = userViewModel,
            postViewModel = postViewModel,
            navController = navController
        )
    }
}
