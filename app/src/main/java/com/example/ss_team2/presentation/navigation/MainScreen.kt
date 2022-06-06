package com.example.ss_team2.presentation.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.ss_team2.presentation.navigation.bottomNavigation.BottomBarScreen
import com.example.ss_team2.presentation.ui.utility.BottomBar


//@Composable
//fun MainScreen(){
//    val navController2 = rememberNavController()
//    Scaffold (
//        bottomBar = { BottomBar(navController2 = navController2)}
//            )
//      {
//        BottomNavGraph(navController2 = navController2)
//    }
//}

//@Composable
//fun BottomBar(navController2: NavHostController){
//    val screens = listOf(
//        BottomBarScreen.Home,
//        BottomBarScreen.Mission,
//        BottomBarScreen.Rank,
//        BottomBarScreen.Profile,
//        BottomBarScreen.Notification
//    )
//    val navBackStackEntry by navController2.currentBackStackEntryAsState()
//    val currentDestination = navBackStackEntry?.destination
//
//    BottomNavigation() {
//        screens.forEach{    screen ->
//                AddItem(screen = screen, currentDestination = currentDestination, navController2 = navController2)
//        }
//    }
//}

//@Composable
//fun RowScope.AddItem(
//    screen: BottomBarScreen,
//    currentDestination: NavDestination?,
//    navController2: NavHostController
//){
//    BottomNavigationItem(
//        label = {
//            Text(text = screen.title)
//        },
//        icon = {
//            Icon(
//                imageVector = screen.icon,
//                contentDescription = "Navigation Icon"
//            )
//        },
//        selected = currentDestination?.hierarchy?.any {
//            it.route == screen.route
//        } == true ,
//        onClick = {
//            navController2.navigate(screen.route){
//                popUpTo(navController2.graph.findStartDestination().id)
//                launchSingleTop = true
//            }
//        }
//    )
//}
//
//@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
//@Composable
//fun MainScreenPreview() {
//    MainScreen()
//}