package com.example.ss_team2.presentation.ui.whatYouLost

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.ui.theme.Iris60
import com.example.ss_team2.ui.theme.TextGray


@Composable
fun WhatYouLost(
    navController: NavController,
    modifier: Modifier = Modifier
){
    val isClicked1 = remember { mutableStateOf(false)}
    val isClicked2 = remember { mutableStateOf(false)}
    val isClicked3 = remember { mutableStateOf(false)}
    val isClicked4 = remember { mutableStateOf(false)}
    val isClicked5 = remember { mutableStateOf(false)}
    val isClicked6 = remember { mutableStateOf(false)}
    val isClicked7 = remember { mutableStateOf(false)}
    val isClicked8 = remember { mutableStateOf(false)}

    val chosen = remember { mutableStateOf("")}

    Column() {
        Lastpage(navController)
        Spacer(modifier = Modifier.height(40.dp))
        SearchBar()
        Spacer(modifier = Modifier.height(40.dp))

        Column() {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.fillMaxWidth()
            ) {
                Button(
                    modifier = Modifier.padding(8.dp),
                    shape = MaterialTheme.shapes.small,
                    onClick = {
                        isClicked1.value = !isClicked1.value
                        chosen.value = "雨傘"
                              },
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = if(isClicked1.value) Color.Gray else Color.White
                    )
                ){
                    Text(
                        text =  "雨傘",
                        fontSize = 12.sp,
                    )
                }

                Button(
                    modifier = Modifier.padding(8.dp),
                    shape = MaterialTheme.shapes.small,
                    onClick = {
                        isClicked2.value = !isClicked2.value
                        chosen.value = "錢包"
                              },
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = if(isClicked2.value) Color.Gray else Color.White
                    )
                ){
                    Text(
                        text =  "錢包",
                        fontSize = 12.sp,
                    )
                }

                Button(
                    modifier = Modifier.padding(8.dp),
                    shape = MaterialTheme.shapes.small,
                    onClick = {
                        isClicked3.value = !isClicked3.value
                        chosen.value = "文具"
                              },
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = if(isClicked3.value) Color.Gray else Color.White
                    )
                ){
                    Text(
                        text =  "文具",
                        fontSize = 12.sp,
                    )
                }

                Button(
                    modifier = Modifier.padding(8.dp),
                    shape = MaterialTheme.shapes.small,
                    onClick = {
                        isClicked4.value = !isClicked4.value
                        chosen.value = "學生證"
                              },
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = if(isClicked4.value) Color.Gray else Color.White
                    )
                ){
                    Text(
                        text =  "學生證",
                        fontSize = 12.sp,
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.fillMaxWidth()
            ) {
                Button(
                    modifier = Modifier.padding(8.dp),
                    shape = MaterialTheme.shapes.small,
                    onClick = {
                        isClicked5.value = !isClicked5.value
                        chosen.value = "腳踏車"
                              },
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = if(isClicked5.value) Color.Gray else Color.White
                    )
                ){
                    Text(
                        text =  "腳踏車",
                        fontSize = 12.sp,
                    )
                }

                Button(
                    modifier = Modifier.padding(8.dp),
                    shape = MaterialTheme.shapes.small,
                    onClick = {
                        isClicked6.value = !isClicked6.value
                        chosen.value = "襪子"
                              },
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = if(isClicked6.value) Color.Gray else Color.White
                    )
                ){
                    Text(
                        text =  "襪子",
                        fontSize = 12.sp,
                    )
                }

                Button(
                    modifier = Modifier.padding(8.dp),
                    shape = MaterialTheme.shapes.small,
                    onClick = {
                        isClicked7.value = !isClicked7.value
                        chosen.value = "水壺"
                              },
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = if(isClicked7.value) Color.Gray else Color.White
                    )
                ){
                    Text(
                        text =  "水壺",
                        fontSize = 12.sp,
                    )
                }

                Button(
                    modifier = Modifier.padding(8.dp),
                    shape = MaterialTheme.shapes.small,
                    onClick = {
                        isClicked8.value = !isClicked8.value
                        chosen.value = "耳機"
                              },
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = if(isClicked8.value) Color.Gray else Color.White
                    )
                ){
                    Text(
                        text =  "耳機",
                        fontSize = 12.sp,
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(160.dp))

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    navController.navigate(
                        route = Screen.WhereYouLost.passWhat(chosen.value)
                    )
                },
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = Iris60
                ),
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    text = "下一步",
                    color = Color.White
                )
            }
        }
    }
}

//@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
//@Composable
//fun WhatYouLostPreview() {
//    SSteam2Theme { WhatYouLost() }
//}


@Composable
fun Lastpage(
    navController: NavController
){
    //var enabled = true  //test
    Icon(
        imageVector = Icons.Default.ArrowBackIos,
        contentDescription = null,
        tint = TextGray,
        modifier = Modifier
            .size(48.dp)
            .padding(start = 8.dp)
            .clickable() {
                navController.popBackStack()
            }
    )
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    // Implement composable here
    Column(
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "你掉了什麼?",
            modifier = Modifier
                .paddingFromBaseline(bottom = 8.dp)
                .padding(start = 8.dp),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = TextGray
        )
        TextField(
            value = "",
            onValueChange = {},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
            },
            shape = MaterialTheme.shapes.small, // the round corner
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface
            ),
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp)
                .padding(start = 8.dp, end = 8.dp)
        )
    }
}

