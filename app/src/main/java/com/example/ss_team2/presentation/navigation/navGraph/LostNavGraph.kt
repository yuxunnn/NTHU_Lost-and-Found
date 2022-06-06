package com.example.ss_team2.presentation.navigation.navGraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.ss_team2.LostListFinalScreen
import com.example.ss_team2.OthersLostListApp
import com.example.ss_team2.RyanJetpack.AddLostList
import com.example.ss_team2.presentation.navigation.LOST_GRAPH_ROUTE
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.ui.FinalScreenWithMoney
import com.example.ss_team2.presentation.ui.OthersFindListApp
import com.example.ss_team2.presentation.ui.whatYouLost.WhatYouLost
import com.example.ss_team2.presentation.ui.whereYouLost.WhereYouLost

fun NavGraphBuilder.lostNavGraph(
    navController: NavController
){
    navigation(
        startDestination = Screen.WhatYouLost.route,
        route = LOST_GRAPH_ROUTE
    ){
        composable(
            route = Screen.WhatYouLost.route
        ){
            WhatYouLost(navController = navController)
        }
        composable(
            route = Screen.WhereYouLost.route
        ){
            WhereYouLost(navController = navController)
        }
        composable(
            route = Screen.LostList.route
        ){
            FinalScreenWithMoney(navController = navController)
        }
        composable(
            route = Screen.AddLostList.route
        ){
            AddLostList(navController = navController)
        }
        composable(
            route = Screen.OthersLostList.route
        ){
            OthersLostListApp(navController)
        }
    }
}