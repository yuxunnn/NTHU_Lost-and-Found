package com.example.ss_team2.presentation.ui.welcome

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.viewModel.ChatViewModel
import com.example.ss_team2.presentation.viewModel.PostViewModel
import com.example.ss_team2.presentation.viewModel.UserViewModel
import com.example.ss_team2.ui.theme.Iris60
import com.example.ss_team2.ui.theme.TextGray

@Composable
fun Welcome (
    postViewModel: PostViewModel,
    chatViewModel: ChatViewModel,
    userViewModel : UserViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
){
    var TypedEmail by remember { mutableStateOf("") }
    var TypedPassword by remember { mutableStateOf("") }

    Column() {
        Title(navController)

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
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextGray
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
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextGray
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
                    onClick = {
//                        userViewModel.getUserItem(TypedEmail)
//                        postViewModel.getUserPosts(TypedEmail)
//                        chatViewModel.chatsByReceive(TypedEmail)
//                        userViewModel.userLogin(TypedEmail, TypedPassword)
                        navController.navigate(route = Screen.Home.route)
                    },
                    colors = ButtonDefaults.textButtonColors(
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
        ForgotPassword()
    }
}

@Composable
fun Title(
    navController: NavController
){
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
            Column(
                modifier = Modifier.padding(top = 30.dp)
            ) {
                Text(
                    text = "歡迎回來!",
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextGray
                )
                Row() {
                    Text(
                        text = "還沒有帳號嗎?",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(top = 12.dp),
                        fontWeight = FontWeight.Bold,
                        color = TextGray
                    )
                    TextButton(onClick = {
                        navController.navigate(route = Screen.Register.route)
                    }) {
                        Text(
                            text = " 按此註冊一個新帳號",
                            fontSize = 20.sp
                        )
                    }
                }
            }
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
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextGray
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
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextGray
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

@Composable
fun LoginButton(navController: NavController){
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
                onClick = {
                          navController.navigate(route = Screen.Home.route)
                }, 
                colors = ButtonDefaults.textButtonColors(
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