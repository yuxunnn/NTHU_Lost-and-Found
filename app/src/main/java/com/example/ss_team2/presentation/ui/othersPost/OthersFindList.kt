package com.example.ss_team2.presentation.ui.othersPost


import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
fun OthersFindListLazyScreen(
    userViewModel: UserViewModel,
    postViewModel: PostViewModel,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = Modifier
    ) {
//        item { UserCard(str = str, drawable = userdrawable, time = time) }
        item {
            PostItemCard(
                postViewModel = postViewModel
            )
        }
        item { Spacer(modifier = Modifier.height(10.dp)) }
//        items(emptyList()) { item ->
//            UserCard(str = item.text, drawable = item.drawable, time = 20)
//        }
    }
}

@Composable
fun OthersFindListHomeScreen(
    userViewModel: UserViewModel,
    postViewModel: PostViewModel,
    modifier: Modifier = Modifier,
) {
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
        OthersFindListLazyScreen(
            userViewModel = userViewModel,
            postViewModel = postViewModel,
        )
    }
}

@Composable
fun OthersFindListFinalScreen(
    userViewModel: UserViewModel,
    postViewModel: PostViewModel,
    modifier: Modifier = Modifier,
    navController: NavController
) {

    Box(modifier = Modifier.fillMaxSize()) {
        OthersFindListHomeScreen(
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
    navController: NavController,
    where: String
) {
    val context = LocalContext.current
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
            onClick = {
                val gmmIntentUri =
                    Uri.parse("geo:120,24?q=$where")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                context.startActivity(mapIntent)
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
    userViewModel: UserViewModel = viewModel(),
    postViewModel: PostViewModel = viewModel(),
    navController: NavController
) {
    Scaffold(
        bottomBar = { OthersFindListBottomNavigation(navController = navController, where = "台達館") }
    ) {
        OthersFindListFinalScreen(
            userViewModel = userViewModel,
            postViewModel = postViewModel,
            navController = navController
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    SSteam2Theme {
        OthersFindListApp(navController = rememberNavController())
    }
}