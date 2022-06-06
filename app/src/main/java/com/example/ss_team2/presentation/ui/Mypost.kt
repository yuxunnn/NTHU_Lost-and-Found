package com.example.ss_team2

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.ui.theme.SSteam2Theme
import com.example.ss_team2.ui.theme.Shapes
import java.lang.ProcessBuilder.Redirect.to


@Composable
fun MyPostApp(
    navController: NavController
){
    Scaffold(
        bottomBar = { MyPostBottomNavigation(navController = navController) }
    ) {
        MyPostFinalScreen(
            str = R.string.home,
            userdrawable = R.drawable.ic_launcher_background,
            time = 20,
            itemdrawable = R.drawable.ic_launcher_foreground,
            description = R.string.description,
            what = R.string.ball,
            where = R.string.home,
            money = 20,
            navController = navController
        )
    }
}

@Composable
fun MyPostHomeScreen(
    modifier: Modifier = Modifier,
    @StringRes str: Int,
    @DrawableRes userdrawable: Int,
    time: Int,
    @DrawableRes itemdrawable: Int,
    @StringRes description: Int,
    @StringRes what: Int,
    @StringRes where: Int,
    money: Int
) {
    Column(
        modifier = Modifier
    ) {
        Text(text = stringResource(id = R.string.MyPost),
            fontWeight = FontWeight.Bold,
            color = Color(0x66,0x70,0x80),
            modifier = Modifier
                .paddingFromBaseline(top = 16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 32.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Divider(color = Color(0x66,0x70,0x80), thickness = 1.dp)
        Spacer(modifier = Modifier.height(16.dp))
        LostListLazyScreen(
            str = str,
            userdrawable = userdrawable,
            time = time,
            itemdrawable = itemdrawable,
            description = description,
            what = what,
            where = where,
            money = money
        )
    }
}

@Composable
fun MyPostFinalScreen(modifier: Modifier = Modifier,
                        @StringRes str: Int,
                        @DrawableRes userdrawable: Int,
                        time: Int,
                        @DrawableRes itemdrawable: Int,
                        @StringRes description: Int,
                        @StringRes what: Int,
                        @StringRes where: Int,
                        money: Int,
                        navController: NavController
){
    Box(modifier = Modifier.fillMaxSize()){
        MyPostHomeScreen(str = str, time = time, userdrawable = userdrawable,
            itemdrawable = itemdrawable, description = description, what = what, where = where, money = money)
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