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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ss_team2.R
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.viewModel.PostViewModel
import com.example.ss_team2.presentation.viewModel.UserViewModel



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
                .padding(horizontal = 20.dp, vertical = 20.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 32.sp
        )
        Divider(color = Color(0x66,0x70,0x80), thickness = 1.dp)
        Spacer(modifier = Modifier.height(16.dp))
        PostListLazyScreen(
            userViewModel = userViewModel,
            postViewModel = postViewModel
        )
    }
}

@Composable
fun LostListFinalScreen(
    modifier: Modifier = Modifier,
    userViewModel: UserViewModel,
    postViewModel: PostViewModel,
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
    userViewModel: UserViewModel,
    postViewModel: PostViewModel,
    navController: NavController
) {
    Scaffold(
        bottomBar = { OthersLostListBottomNavigation(navController = navController, where = "台達館") }
    ) {
        LostListFinalScreen(
            userViewModel = userViewModel,
            postViewModel = postViewModel,
            navController = navController
        )
    }
}
