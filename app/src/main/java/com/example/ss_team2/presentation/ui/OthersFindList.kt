package com.example.ss_team2.presentation.ui


import android.content.Intent
import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ss_team2.R
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.ui.theme.SSteam2Theme

@Composable
fun UserCard(
    modifier: Modifier=Modifier,
    @StringRes str: Int,
    @DrawableRes drawable: Int,
    time: Int
){
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
    }
}

@Composable
fun WhatAndWhereColElement2(
    what: String,
    where: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "What",
            modifier = Modifier.padding(4.dp),
            fontSize = 12.sp,
            color = Color(66,70,80),
            fontWeight = FontWeight.Bold
        )
        Surface(
            modifier = modifier,
            shape = MaterialTheme.shapes.small,
            color = Color(66,70,80)
        ){
            Text(
                text = what,
                modifier = Modifier.padding(6.dp),
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Text(
            text = "Where",
            modifier = Modifier.padding(4.dp),
            fontSize = 12.sp,
            color = Color(66,70,80),
            fontWeight = FontWeight.Bold
        )
        Surface(
            modifier = modifier,
            shape = MaterialTheme.shapes.small,
            color = Color(66,70,80)
        ){
            Text(
                text = where,
                modifier = Modifier.padding(6.dp),
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ItemCard(
    modifier: Modifier=Modifier,
    @DrawableRes drawable: Int,
    @StringRes description: Int,
    @StringRes what: Int,
    @StringRes where: Int
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .background(Color(220, 220, 220)),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(36.dp)
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(280.dp)
                .width(160.dp)
                .clip(RectangleShape)
                .padding(4.dp)
        )
        Column(modifier = Modifier) {
            WhatAndWhereColElement2(what = stringResource(id = what),
                where = stringResource(id = where))
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = stringResource(id = description), fontSize = 12.sp)
        }

    }
}

@Composable
fun OthersFindListLazyScreen(
    modifier: Modifier=Modifier,
    @StringRes str: Int,
    @DrawableRes userdrawable: Int,
    time: Int,
    @DrawableRes itemdrawable: Int,
    @StringRes description: Int,
    @StringRes what: Int,
    @StringRes where: Int){
    LazyColumn(
        modifier = Modifier
    ) {
        item{ UserCard(str = str, drawable = userdrawable, time = time) }
        item{ ItemCard(drawable = itemdrawable, description = description, what = what, where = where) }
        item{ Spacer(modifier = Modifier.height(10.dp))}
        items(TestData){
                item -> UserCard(str = item.text, drawable = item.drawable, time = 20)
        }
    }
}

@Composable
fun OthersFindListHomeScreen(
    modifier: Modifier = Modifier,
    @StringRes str: Int,
    @DrawableRes userdrawable: Int,
    time: Int,
    @DrawableRes itemdrawable: Int,
    @StringRes description: Int,
    @StringRes what: Int,
    @StringRes where: Int
) {
    Column(
        modifier = Modifier
    ) {
        Text(text = stringResource(id = R.string.FindList),
            fontWeight = FontWeight.Bold,
            color = Color(0x66,0x70,0x80),
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 20.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 32.sp
        )
        Divider(color = Color(0x66,0x70,0x80), thickness = 1.dp)
        Spacer(modifier = Modifier.height(16.dp))
        OthersFindListLazyScreen(
            str = str,
            userdrawable = userdrawable,
            time = time,
            itemdrawable = itemdrawable,
            description = description,
            what = what,
            where = where
        )
    }
}

@Composable
fun OthersFindListFinalScreen(modifier: Modifier = Modifier,
                        @StringRes str: Int,
                        @DrawableRes userdrawable: Int,
                        time: Int,
                        @DrawableRes itemdrawable: Int,
                        @StringRes description: Int,
                        @StringRes what: Int,
                        @StringRes where: Int,
                        navController: NavController
){
    Box(modifier = Modifier.fillMaxSize()){
        OthersFindListHomeScreen(str = str, time = time, userdrawable = userdrawable,
        itemdrawable = itemdrawable, description = description, what = what, where = where)
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

private val TestData = listOf(
    R.drawable.ic_launcher_background to R.string.ball,
    R.drawable.ic_launcher_background to R.string.ball,
).map { DrawableStringPair(it.first, it.second) }

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
                // Attempt to start an activity that can handle the Intent
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
    navController: NavController
){
    Scaffold(
        bottomBar = { OthersFindListBottomNavigation(navController = navController, where = "清大圖書館") }
    ) {
        OthersFindListFinalScreen(
            str = R.string.home,
            userdrawable = R.drawable.ic_launcher_background,
            time = 20,
            itemdrawable = R.drawable.ic_launcher_foreground,
            description = R.string.description,
            what = R.string.ball,
            where = R.string.home,
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