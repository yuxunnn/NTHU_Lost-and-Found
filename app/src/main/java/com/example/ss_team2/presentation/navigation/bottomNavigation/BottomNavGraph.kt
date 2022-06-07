//package com.example.ss_team2.presentation.navigation.bottomNavigation
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import com.example.ss_team2.presentation.ui.NotificationFinalScreen
//import com.example.ss_team2.domain.model.userFrog
//import com.example.ss_team2.presentation.ui.homepage.HomepageScreen
//import com.example.ss_team2.presentation.ui.profile.MyProfileScreen
//import com.example.ss_team2.presentation.ui.rankPage.RankPage
//import com.example.ss_team2.presentation.ui.taskList.TaskList
//
//
//
//@Composable
//fun BottomNavGraph(navController2: NavHostController ){
//    NavHost(
//        navController = navController2,
//        startDestination = BottomBarScreen.Home.route
//    ){
//        composable(route = BottomBarScreen.Home.route){
//            HomepageScreen(navController = navController2)
//        }
//        composable(route = BottomBarScreen.Mission.route){
//            TaskList(nav)
//        }
//        composable(route = BottomBarScreen.Rank.route){
//            RankPage()
//        }
//        composable(route = BottomBarScreen.Profile.route){
//            MyProfileScreen(user = userFrog, navController = navController2)
//        }
//        composable(route = BottomBarScreen.Notification.route){
//            NotificationFinalScreen()
//        }
//    }
//
//}