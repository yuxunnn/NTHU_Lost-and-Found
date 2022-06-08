package com.example.ss_team2.presentation.navigation.navGraph

import androidx.navigation.*
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.ss_team2.presentation.ui.othersPost.OthersLostListApp
import com.example.ss_team2.presentation.ui.AddLostList
import com.example.ss_team2.presentation.navigation.LOST_GRAPH_ROUTE
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.navigation.WHAT_ARGUMENT_KEY
import com.example.ss_team2.presentation.navigation.WHERE_ARGUMENT_KEY
import com.example.ss_team2.presentation.ui.postList.FinalScreenWithMoney
import com.example.ss_team2.presentation.ui.whatYouLost.WhatYouLost
import com.example.ss_team2.presentation.ui.whereYouLost.WhereYouLost
import com.example.ss_team2.presentation.viewModel.PostViewModel

fun NavGraphBuilder.lostNavGraph(
    postViewModel: PostViewModel,
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
                    postViewModel = postViewModel,
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
                postViewModel = postViewModel,
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