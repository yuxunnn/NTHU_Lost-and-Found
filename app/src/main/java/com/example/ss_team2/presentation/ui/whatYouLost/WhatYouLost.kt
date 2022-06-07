package com.example.ss_team2.presentation.ui.whatYouLost

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ss_team2.ui.theme.SSteam2Theme
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.ui.theme.Iris60

@Composable
fun WhatYouLost(
    navController: NavController
){
    Column() {
        Lastpage(navController)
        Spacer(modifier = Modifier.height(40.dp))
        SearchBar()
        Spacer(modifier = Modifier.height(40.dp))
        ObjectLabels()
        Spacer(modifier = Modifier.height(160.dp))
        NextButton(navController)
    }
}



@Composable
fun Lastpage(
    navController: NavController
){
    //var enabled = true  //test
    Icon(
        imageVector = Icons.Default.ArrowBackIos,
        contentDescription = null,
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
            fontWeight = FontWeight.W600 //粗體
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
                .padding(start = 8.dp,end = 8.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun SearchBarPreview() {
    SSteam2Theme { SearchBar(Modifier.padding(8.dp)) }
}

@Composable
fun ObjectLabelsElement(
    modifier: Modifier = Modifier,
    text: String
){
    Card(
        modifier = Modifier.padding(8.dp).clickable {  },
        shape = MaterialTheme.shapes.small,
        elevation = 3.dp    //shadow
    ){
        Box(
            modifier = Modifier
                .padding(8.dp)
                .width(40.dp),
            contentAlignment = Center,
        ){
            Text(
                text =  text,
                fontSize = 12.sp,
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun ObjectLabelsElementPreview() {
    SSteam2Theme { ObjectLabelsElement(Modifier.padding(8.dp), "雨傘") }
}




@Composable
fun ObjectLabels(
    modifier: Modifier = Modifier
){
    Column() {
        LazyRow(
            horizontalArrangement = Arrangement.SpaceBetween,
            contentPadding = PaddingValues(horizontal = 1.dp),
            modifier = modifier.fillMaxWidth()
        ) {
            items(objectLabels1) { item ->
                ObjectLabelsElement(Modifier, item)
            }
        }
        LazyRow(
            horizontalArrangement = Arrangement.SpaceBetween,
            contentPadding = PaddingValues(horizontal = 1.dp),
            modifier = modifier.fillMaxWidth()
        ) {
            items(objectLabels2) { item ->
                ObjectLabelsElement(Modifier, item)
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun ObjectLabelsPreview() {
    SSteam2Theme { ObjectLabels()}
}

@Composable
fun NextButton(
    navController: NavController
){
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                      navController.navigate(route = Screen.WhereYouLost.route)
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
