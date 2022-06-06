package com.example.ss_team2.presentation.ui.firstpage

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ss_team2.presentation.navigation.FIND_GRAPH_ROUTE
import com.example.ss_team2.presentation.navigation.LOST_GRAPH_ROUTE
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.ui.theme.SSteam2Theme

@Composable
fun FirstPage(
    navController: NavController
){
    Column() {
        Spacer(modifier = Modifier.height(120.dp))
        Title()
        Spacer(modifier = Modifier.height(240.dp))
        FirstButton(navController)
        Spacer(modifier = Modifier.height(40.dp))
        SecondButton(navController)
    }
}




@Composable
fun FirstButton(
    navController: NavController
){
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        Button(
            onClick = {
                      navController.navigate(route = Screen.Register.route)
            },
            shape = RoundedCornerShape(35.dp),
            modifier = Modifier
                .width(300.dp)
                .height(100.dp),
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.Gray
            )
        ) {
            Text(
                text = "註冊新帳號",
                fontSize = 36.sp,
            )
        }
    }
}



@Composable
fun SecondButton(
    navController: NavController
){
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        Button(
            onClick = {
                      navController.navigate(route = Screen.Login.route)
            },
            shape = RoundedCornerShape(35.dp),
            modifier = Modifier
                .width(300.dp)
                .height(100.dp),
        ) {
            Text(
                text = "登入現有帳號",
                fontSize = 36.sp,
                //modifier = Modifier.padding(start = 30.dp, end = 30.dp, top = 15.dp, bottom = 15.dp)
            )
        }
    }
}

@Composable
fun Title(){
    Column() {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "頂大失物尋寶",
                fontSize = 50.sp
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun TitlePreview(){
    SSteam2Theme {Title()}
}