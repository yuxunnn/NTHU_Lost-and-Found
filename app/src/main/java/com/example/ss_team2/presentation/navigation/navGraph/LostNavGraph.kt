package com.example.ss_team2.presentation.navigation.navGraph

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.ss_team2.LostListFinalScreen
import com.example.ss_team2.OthersLostListApp
import com.example.ss_team2.RyanJetpack.AddLostList
import com.example.ss_team2.presentation.navigation.LOST_GRAPH_ROUTE
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.navigation.WHAT_ARGUMENT_KEY
import com.example.ss_team2.presentation.navigation.WHERE_ARGUMENT_KEY
import com.example.ss_team2.presentation.ui.FinalScreenWithMoney
import com.example.ss_team2.presentation.ui.FindListFinalScreen
import com.example.ss_team2.presentation.ui.OthersFindListApp
import com.example.ss_team2.presentation.ui.whatYouLost.WhatYouLost
import com.example.ss_team2.presentation.ui.whereYouFind.WhereYouFind
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
            entry ->
                WhereYouLost(navController = navController,
                what = entry.arguments?.getString(WHAT_ARGUMENT_KEY).toString())
        }
        composable(
            route = Screen.LostList.route,
            arguments = listOf(
                navArgument(WHAT_ARGUMENT_KEY){
                    type = NavType.StringType
                },
                navArgument(WHERE_ARGUMENT_KEY){
                    type = NavType.StringType
                }
            )
        ){
                entry ->
            FinalScreenWithMoney(
                navController = navController,
                what = entry.arguments?.getString("what").toString(),
                where = entry.arguments?.getString("where").toString())
        }
        composable(
            route = Screen.AddLostList.route
        ){
            entry ->
                AddLostList(
                    navController = navController,
                    what = entry.arguments?.getString(WHAT_ARGUMENT_KEY).toString(),
                    where = entry.arguments?.getString(WHERE_ARGUMENT_KEY).toString()
                )
        }
        composable(
            route = Screen.OthersLostList.route
        ){
            OthersLostListApp(navController)
        }
    }
}