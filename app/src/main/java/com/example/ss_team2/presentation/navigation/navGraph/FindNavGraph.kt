package com.example.ss_team2.presentation.navigation.navGraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.ss_team2.presentation.navigation.FIND_GRAPH_ROUTE
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.ui.AddFindList
import com.example.ss_team2.presentation.ui.FindListFinalScreen
import com.example.ss_team2.presentation.ui.OthersFindListApp
import com.example.ss_team2.presentation.ui.whatYouFind.WhatYouFind
import com.example.ss_team2.presentation.ui.whereYouFind.WhereYouFind


fun NavGraphBuilder.findNavGraph(
    navController: NavController
){
    navigation(
        startDestination = Screen.WhatYouFind.route,
        route = FIND_GRAPH_ROUTE
    ){
        composable(
            route = Screen.WhatYouFind.route
        ){
            WhatYouFind(navController = navController)
        }
        composable(
            route = Screen.WhereYouFind.route
        ){
            WhereYouFind(navController = navController)
        }
        composable(
            route = Screen.FindList.route
        ){
            FindListFinalScreen(navController = navController)
        }
        composable(
            route = Screen.AddFindList.route
        ){
            AddFindList(navController = navController)
        }
        composable(
            route = Screen.OthersFindList.route
        ){
            OthersFindListApp(navController = navController)
        }
    }
}