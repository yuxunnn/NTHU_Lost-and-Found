package com.example.ss_team2


import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
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
import androidx.navigation.navArgument
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.ui.DrawableStringPair
import com.example.ss_team2.presentation.ui.ItemCard
import com.example.ss_team2.presentation.ui.UserCard
import com.example.ss_team2.ui.theme.SSteam2Theme


@Composable
fun UserCardWithMoney(
    modifier: Modifier=Modifier,
    @StringRes str: Int,
    @DrawableRes drawable: Int,
    time: Int,
    money: Int
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
    @StringRes str: Int,
    @DrawableRes userdrawable: Int,
    time: Int,
    @DrawableRes itemdrawable: Int,
    @StringRes description: Int,
    @StringRes what: Int,
    @StringRes where: Int,
    money: Int
){
    LazyColumn(
        modifier = Modifier
    ) {
        item{ UserCardWithMoney(str = str, drawable = userdrawable, time = time, money = money) }
        item{ ItemCard(drawable = itemdrawable, description = description, what = what, where = where) }
        item{ Spacer(modifier = Modifier.height(10.dp))}
        items(TestData){
                item -> UserCard(str = item.text, drawable = item.drawable, time = 20)
        }
    }
}

@Composable
fun LostListHomeScreen(
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
        Text(text = stringResource(id = R.string.LostList),
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
fun LostListFinalScreen(modifier: Modifier = Modifier,
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
        LostListHomeScreen(str = str, time = time, userdrawable = userdrawable,
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

private val TestData = listOf(
    R.drawable.ic_launcher_background to R.string.ball,
    R.drawable.ic_launcher_background to R.string.ball,
    R.drawable.ic_launcher_background to R.string.ball,
    R.drawable.ic_launcher_background to R.string.ball,
    R.drawable.ic_launcher_background to R.string.ball,
    R.drawable.ic_launcher_background to R.string.ball
).map { DrawableStringPair(it.first, it.second) }

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
fun OthersLostListApp(navController: NavController){
    Scaffold(
        bottomBar = { OthersLostListBottomNavigation(navController = navController) }
    ) {
        LostListFinalScreen(
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    SSteam2Theme {
        OthersLostListApp(navController = rememberNavController())
    }
}