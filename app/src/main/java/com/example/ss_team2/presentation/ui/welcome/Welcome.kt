package com.example.ss_team2.presentation.ui.welcome

import android.util.Log
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
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
import com.example.ss_team2.ui.theme.Purple200
import com.example.ss_team2.ui.theme.TextGray

@Composable
fun Welcome (
    postViewModel: PostViewModel,
    chatViewModel: ChatViewModel,
    userViewModel : UserViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
){
    var TypedEmail = remember { mutableStateOf("") }
    var TypedPassword = remember { mutableStateOf("") }
    var (snackbarVisibleState, setSnackBarState) = remember { mutableStateOf(false) }
    val user by userViewModel.user.collectAsState()

    Column(
        Modifier.fillMaxHeight()
    ) {
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
                        text = "信箱或手機號碼",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextGray
                    )
                }
                TextField(
                    value = TypedEmail.value,
                    onValueChange = { TypedEmail.value = it },
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
                    value = TypedPassword.value,
                    onValueChange = { TypedPassword.value = it },
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
                        userViewModel.userLogin(TypedEmail.value, TypedPassword.value)
                        //snackbar
                        if(user == null){
                            snackbarVisibleState = true
                        }else{
                            snackbarVisibleState = false
                            navController.navigate(route = Screen.Home.route)
                        }
                        //Log.d("Android", "Response: $snackbarVisibleState")
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
        if (snackbarVisibleState) {
            Snackbar(
                action = {
                    TextButton(onClick = {
                        snackbarVisibleState = false
                    }) {
                        Text(
                            text = "確認",
                             color = Purple200
                        )
                    }
                },
                modifier = Modifier.padding(8.dp)
            ) { Text(text = "查無此帳號或輸入密碼有誤!") }
        }
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