package com.example.ss_team2.presentation.navigation.bottomNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ss_team2.NotificationFinalScreen
import com.example.ss_team2.domain.model.userFrog
import com.example.ss_team2.presentation.ui.homepage.HomepageScreen
import com.example.ss_team2.presentation.ui.profile.MyProfileScreen
import com.example.ss_team2.presentation.ui.rankPage.RankPage
import com.example.ss_team2.presentation.ui.taskList.TaskList



@Composable
fun BottomNavGraph(navController: NavHostController ){
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ){
        composable(route = BottomBarScreen.Home.route){
            HomepageScreen(navController = navController)
        }
        composable(route = BottomBarScreen.Mission.route){
            TaskList()
        }
        composable(route = BottomBarScreen.Rank.route){
            RankPage()
        }
        composable(route = BottomBarScreen.Profile.route){
            MyProfileScreen(user = userFrog)
        }
        composable(route = BottomBarScreen.Notification.route){
            NotificationFinalScreen()
        }
    }

}