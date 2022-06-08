package com.example.ss_team2.presentation.ui.postList

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ss_team2.R
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.ui.utility.WhatAndWhereRowElement
import com.example.ss_team2.presentation.viewModel.PostViewModel
import com.example.ss_team2.ui.theme.SSteam2Theme

@Composable
fun FindListHomeScreen(
    what: String,
    where: String,
    postViewModel: PostViewModel,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.Finder),
            fontWeight = FontWeight.Bold,
            color = Color(0x66, 0x70, 0x80),
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 20.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 32.sp
        )
        Divider(color = Color(0x66, 0x70, 0x80), thickness = 1.dp)
        Spacer(modifier = Modifier.height(10.dp))
        WhatAndWhereRowElement(
            what = what,
            where = where
        )
        Spacer(modifier = Modifier.height(10.dp))
        PostListLazyScreen(
            postType = "find",
            postViewModel = postViewModel,
            navController = navController
        )
    }

}

@Composable
fun FindListFinalScreen(
    modifier: Modifier = Modifier,
    postViewModel: PostViewModel,
    what: String,
    where: String,
    navController: NavController
) {

    Box(modifier = Modifier.fillMaxSize()) {
        FindListHomeScreen(
            what = what,
            where = where,
            postViewModel = postViewModel,
            navController = navController
        )
        PostListButton(
            icon = Icons.Default.Add,
            onClick = {
                navController.navigate(
                    route = Screen.AddFindList.passWhatAndWhere(
                        what = what,
                        where = where
                    )
                )
            },
            modifier = Modifier.align(Alignment.BottomEnd)
        )
        PostListButton(
            icon = Icons.Default.Home,
            onClick = { navController.navigate(route = Screen.Home.route) },
            modifier = Modifier.align(Alignment.BottomStart)
        )
    }
}