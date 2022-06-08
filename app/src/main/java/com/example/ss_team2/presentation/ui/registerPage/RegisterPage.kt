package com.example.ss_team2.presentation.ui.registerPage


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.ss_team2.ui.theme.SSteam2Theme
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.viewModel.UserViewModel
import com.example.ss_team2.type.UserCreateInput
import com.example.ss_team2.type.adapter.UserCreateInput_InputAdapter
import com.example.ss_team2.ui.theme.Iris60


@Composable
fun RegisterPage (
    navController: NavController,
    userViewModel: UserViewModel = viewModel(),
    modifier: Modifier = Modifier
){
    Column {

        var TypedName by remember { mutableStateOf("") }

        var mExpanded by remember { mutableStateOf(false) }
        val mCities = listOf("台灣大學", "清華大學", "交通大學", "政治大學")
        var mSelectedText by remember { mutableStateOf("台灣大學") }
        var mTextFieldSize by remember { mutableStateOf(Size.Zero) }
        val icon = if (mExpanded)
            Icons.Filled.KeyboardArrowUp
        else
            Icons.Filled.KeyboardArrowDown

        var TypedPhone by remember { mutableStateOf("") }
        var TypedEmail by remember { mutableStateOf("") }
        var TypedPassword by remember { mutableStateOf("") }


        Title()

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
                        text = "用戶名",
                        fontSize = 20.sp
                    )
                }
                TextField(
                    value = TypedName,
                    onValueChange = { TypedName = it },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.surface
                    ),
                    placeholder = {
                        Text("陳xx")
                    },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
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
                        text = "學校",
                        fontSize = 20.sp
                    )
                }
                // Create an Outlined Text Field
                // with icon and not expanded
                TextField(
                    value = mSelectedText,
                    onValueChange = { mSelectedText = it },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .width(350.dp)
                        .onGloballyPositioned { coordinates ->
                            // This value is used to assign to
                            // the DropDown the same width
                            mTextFieldSize = coordinates.size.toSize()
                        }
                        .padding(top = 5.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.surface
                    ),
                    trailingIcon = {
                        Icon(icon, "contentDescription",
                            Modifier.clickable { mExpanded = !mExpanded })
                    }
                )

                // Create a drop-down menu with list of cities,
                // when clicked, set the Text Field text as the city selected
                DropdownMenu(
                    expanded = mExpanded,
                    onDismissRequest = { mExpanded = false },
                    modifier = Modifier
                        .width(with(LocalDensity.current) { mTextFieldSize.width.toDp() })
                ) {
                    mCities.forEach { label ->
                        DropdownMenuItem(onClick = {
                            mSelectedText = label
                            mExpanded = false
                        }) {
                            Text(text = label)
                        }
                    }
                }
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
                        text = "電話",
                        fontSize = 20.sp
                    )
                }
                TextField(
                    value = TypedPhone,
                    onValueChange = { TypedPhone = it },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.surface
                    ),
                    placeholder = {
                        Text("09xxxxxxxx")
                    },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
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
                    modifier = Modifier
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
                    modifier = Modifier
                        .width(350.dp)
                        .heightIn(min = 56.dp)
                        .padding(top = 5.dp)
                )
            }
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 40.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Row(
                Modifier.width(100.dp)
            ) {
                Button(
                    onClick = {
                        userViewModel.createUser(
                            UserCreateInput(
                                userName = TypedName,
                                userSchool = mSelectedText,
                                userPhoneNumber = TypedPhone,
                                userEmail = TypedEmail,
                                userPassword = TypedPassword
                            )
                        )
                        navController.navigate(route = Screen.First.route){
                            popUpTo(Screen.First.route){
                                inclusive = true
                            }
                        }
                    }, colors = ButtonDefaults.textButtonColors(
                        backgroundColor = Iris60
                    ),
                    modifier = Modifier
                        .height(56.dp)
                        .width(100.dp)
                ) {
                    Text(
                        text = "註冊",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}

//@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
//@Composable
//fun RegisterPagePreview() {
//    SSteam2Theme { }
//}

@Composable
fun Title (){
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        Text(
            text = "註冊",
            fontSize =  36.sp
        )
    }
}