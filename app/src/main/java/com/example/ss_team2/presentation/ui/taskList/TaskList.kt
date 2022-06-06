package com.example.ss_team2.presentation.ui.taskList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.CheckCircleOutline
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ss_team2.ui.theme.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.ui.homepage.HomepageScreen
import com.example.ss_team2.presentation.ui.utility.BottomBar


@Composable
fun TaskList(navController: NavController){
    Column {
        Title()
        Divider(startIndent = 0.dp, thickness = 3.dp, color = Color.Black)
        MoneyAndShop(money = "520", navController = navController)
        TaskCards()

        //BottomNavigation
    }
}


@Composable
fun Title(){
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "任務清單",
            fontSize = 36.sp
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun TitlePreview() {
    SSteam2Theme { Title() }
}

@Composable
fun MoneyAndShop(
    modifier: Modifier = Modifier,
    money: String,
    navController: NavController
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ){
        Row() {
            Icon(
                imageVector = Icons.Default.AttachMoney,
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
            )
            Text(
                text = money,
                fontSize = 45.sp //may bug
            )
        }
        Icon(
            imageVector = Icons.Default.Storefront,
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clickable() {
                    navController.navigate(route = Screen.Shop.route)
                }
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun MoneyAndShopPreview() {
    SSteam2Theme { MoneyAndShop(money = "520", navController = rememberNavController()) }
}

var tasks = listOf(
        "每日登入",
        "查看一則遺失物貼文",
        "塗鴉其他學校五次",
        "幫助他人找回遺失物三次"
        )

@Composable
fun TaskCard(
    modifier: Modifier = Modifier,
    Yourtask : String
){
    var progress by remember {  mutableStateOf(0.3f) } //just for testing
    Card(
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 16.dp)
            .height(72.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 3.dp,    //shadow
        backgroundColor = Iris60
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = modifier.fillMaxWidth()
        ){
             Column(
                 modifier = Modifier.padding(start = 10.dp),
             ){
                Text(
                    text = Yourtask,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(top = 12.dp),
                    color = White
                )
                 Spacer(modifier = Modifier.height(16.dp))
                 LinearProgressIndicator(
                     backgroundColor = Purple200,
                     progress = progress,
                     color = Purple700,
                     modifier = Modifier.height(6.dp)
                 )
             }
             Column(){
                 Icon(
                     imageVector = Icons.Default.CheckCircleOutline,
                     contentDescription = null,
                     modifier = Modifier
                         .size(48.dp)
                         .clickable() {}
                 )
                 Row(){
                     Icon(
                         imageVector = Icons.Default.AttachMoney,
                         contentDescription = null,
                         modifier = Modifier
                             .size(20.dp)
                     )
                     Text(text = "+40")
                 }
             }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun TaskCardPreview() {
    SSteam2Theme { TaskCard(Yourtask = "每日登入") }
}

@Composable
fun TaskCards(
    modifier: Modifier = Modifier,
){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(tasks) { item ->
            TaskCard(Modifier, item)
        }
    }
}

@Composable
fun Quest(
    navController: NavController
) {
    SSteam2Theme {
        Scaffold(
            bottomBar = { BottomBar(modifier = Modifier, navController) }
        ) {
            TaskList(navController = navController)
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun TaskCardsPreview() {
    SSteam2Theme { TaskCards() }
}