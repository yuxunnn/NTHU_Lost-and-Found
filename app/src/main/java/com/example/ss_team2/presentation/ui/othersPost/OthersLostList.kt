package com.example.ss_team2.presentation.ui.othersPost


import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ss_team2.R
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.viewModel.PostViewModel
import com.example.ss_team2.presentation.viewModel.UserViewModel
import com.example.ss_team2.ui.theme.SSteam2Theme


@Composable
fun UserCardWithMoney(
    modifier: Modifier = Modifier,
    @StringRes str: Int,
    @DrawableRes drawable: Int,
    time: Int,
    money: Int
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .padding(8.dp)
                .clip(CircleShape)
        )
        Column(modifier = Modifier) {
            Text(
                text = stringResource(id = str),
                fontSize = 12.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = ("$time 分鐘前"),
                color = Color.Gray,
                fontSize = 8.sp
            )
        }
        Text(
            text = "+ $money$",
            modifier = Modifier.width(40.dp),
            fontSize = 12.sp,
            textAlign = TextAlign.End
        )
    }
}

@Composable
fun LostListLazyScreen(
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

@Composable
fun LostListHomeScreen(
    modifier: Modifier = Modifier,
    userViewModel: UserViewModel,
    postViewModel: PostViewModel
) {
    Column(
        modifier = Modifier
    ) {
        Text(
            text = stringResource(id = R.string.LostList),
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
            postViewModel = postViewModel
        )
    }
}

@Composable
fun LostListFinalScreen(
    modifier: Modifier = Modifier,
    userViewModel: UserViewModel = viewModel(),
    postViewModel: PostViewModel = viewModel(),
    navController: NavController
) {
    Box(modifier = Modifier.fillMaxSize()) {
        LostListHomeScreen(
            userViewModel = userViewModel,
            postViewModel = postViewModel
        )
        Icon(
            Icons.Filled.ArrowBack,
            "",
            modifier = Modifier
                .align(Alignment.TopStart)
                .clickable { navController.popBackStack() }
                .padding(16.dp)
        )

    }
}

@Composable
private fun OthersLostListBottomNavigation(
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
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            },
            label = {
                Text("成功歸還")
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
fun OthersLostListApp(
    navController: NavController
) {
    Scaffold(
        bottomBar = { OthersLostListBottomNavigation(navController = navController) }
    ) {
        LostListFinalScreen(
            navController = navController
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    SSteam2Theme {
        OthersLostListApp(navController = rememberNavController())
    }
}