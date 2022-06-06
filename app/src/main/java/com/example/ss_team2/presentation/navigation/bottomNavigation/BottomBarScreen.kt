package com.example.ss_team2.presentation.navigation.bottomNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector


sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Home: BottomBarScreen(
        route = "home",
        title = "主頁",
        icon =  Icons.Default.Home
    )
    object Mission: BottomBarScreen(
        route = "mission",
        title = "任務",
        icon =  Icons.Default.Star
    )
    object Rank: BottomBarScreen(
        route = "rank",
        title = "積分榜",
        icon =  Icons.Default.Email
    )
    object Profile: BottomBarScreen(
        route = "profile",
        title = "個人資訊",
        icon =  Icons.Default.AccountCircle
    )
    object Notification: BottomBarScreen(
        route = "notification",
        title = "通知",
        icon =  Icons.Default.Notifications
    )
}
