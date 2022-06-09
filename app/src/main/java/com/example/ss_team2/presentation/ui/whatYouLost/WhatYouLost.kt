package com.example.ss_team2.presentation.ui.whatYouLost

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import com.example.ss_team2.presentation.ui.whatYouFind.WhatButton
import com.example.ss_team2.ui.theme.Iris60
import com.example.ss_team2.ui.theme.TextGray


@Composable
fun WhatYouLost(
    navController: NavController,
    modifier: Modifier = Modifier
) {

    val chosen = remember { mutableStateOf("雨傘") }

    Column() {
        Lastpage(navController)
        Spacer(modifier = Modifier.height(40.dp))
        SearchBar()
        Spacer(modifier = Modifier.height(40.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(objectLabels1) { item ->
                WhatButton(
                    chosen = chosen.value,
                    text = item,
                    onClick = { chosen.value = item }
                )
            }
            items(objectLabels2) { item ->
                WhatButton(
                    chosen = chosen.value,
                    text = item,
                    onClick = { chosen.value = item }
                )
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

@Composable
fun Lastpage(
    navController: NavController
) {
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

