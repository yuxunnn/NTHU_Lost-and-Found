package com.example.ss_team2.presentation.ui.welcomPage

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ss_team2.ui.theme.Iris60
import com.example.ss_team2.ui.theme.SSteam2Theme

@Composable
fun Welcome (){
    Column() {
        Title()
        LoginEmail()
        LoginPassword()
        LoginButton()
        ForgotPassword()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun WelcomePreview(){
    SSteam2Theme() {
        Welcome()
    }
}

@Composable
fun Title(){
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
            Column(
                modifier = Modifier.padding(top = 30.dp)
            ) {
                Text(
                    text = "歡迎回來!",
                    fontSize = 50.sp
                )
                Row() {
                    Text(
                        text = "還沒有帳號嗎?",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(top = 12.dp)
                    )
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(
                            text = " 按此註冊一個新帳號",
                            fontSize = 20.sp
                        )
                    }
                }
            }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun TitlePreview(){
    SSteam2Theme() {
        Title()
    }
}

@Composable
fun LoginEmail (
    modifier : Modifier = Modifier
){
    var TypedEmail by remember { mutableStateOf("") }

    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Column() {
            Row(
                Modifier.width(350.dp),
            ) {
                Text(
                    text = "信箱",
                    fontSize = 20.sp
                )
            }
            TextField(
                value = TypedEmail,
                onValueChange = { TypedEmail = it },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface
                ),
                placeholder = {
                    Text("xxxx@gmail.com")
                },
                shape = RoundedCornerShape(8.dp),
                modifier = modifier
                    .width(350.dp)
                    .heightIn(min = 56.dp)
                    .padding(top = 5.dp)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun LoginEmailPreview() {
    SSteam2Theme() {
        LoginEmail()
    }
}

@Composable
fun LoginPassword (
    modifier : Modifier = Modifier
){
    var TypedPassword by remember { mutableStateOf("") }

    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Column() {
            Row(
                Modifier.width(350.dp),
            ) {
                Text(
                    text = "密碼",
                    fontSize = 20.sp
                )
            }
            TextField(
                value = TypedPassword,
                onValueChange = { TypedPassword = it },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface
                ),
                placeholder = {
                    Text("********")
                },
                shape = RoundedCornerShape(8.dp),
                modifier = modifier
                    .width(350.dp)
                    .heightIn(min = 56.dp)
                    .padding(top = 5.dp)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun LoginPreview() {
    SSteam2Theme() {
        LoginPassword()
    }
}

@Composable
fun LoginButton(){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalArrangement = Arrangement.Center
    ){
        Row(
            Modifier.width(350.dp)
        ) {
            Button(
                onClick = {}, colors = ButtonDefaults.textButtonColors(
                    backgroundColor = Iris60
                ),
                modifier = Modifier
                    .height(56.dp)
                    .width(350.dp)
            ) {
                Text(
                    text = "登入",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun LoginButtonPreview() {
    SSteam2Theme() {
        LoginButton()
    }
}

@Composable
fun ForgotPassword(){
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        TextButton(onClick = { /*TODO*/ }) {
            Text(
                text = "忘記密碼"
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun ForgotPasswordPreview() {
    SSteam2Theme() {
        ForgotPassword()
    }
}