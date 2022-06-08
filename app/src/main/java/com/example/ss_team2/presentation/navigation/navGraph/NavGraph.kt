package com.example.ss_team2.presentation.navigation.navGraph

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ss_team2.presentation.ui.EditPost
import com.example.ss_team2.presentation.ui.MyPostApp
import com.example.ss_team2.presentation.ui.Notification
import com.example.ss_team2.presentation.navigation.ROOT_GRAPH_ROUTE
import com.example.ss_team2.presentation.navigation.Screen
import androidx.navigation.navArgument
import com.example.ss_team2.presentation.navigation.*
import com.example.ss_team2.presentation.ui.Confirmation
import com.example.ss_team2.presentation.ui.chatList.ChatList
import com.example.ss_team2.presentation.ui.chatRoom.Dialog
import com.example.ss_team2.presentation.ui.firstpage.FirstPage
import com.example.ss_team2.presentation.ui.homepage.Homepage
import com.example.ss_team2.presentation.ui.mapScreen.MapScreen
import com.example.ss_team2.presentation.ui.profile.MyProfile
import com.example.ss_team2.presentation.ui.rankPage.Rank
import com.example.ss_team2.presentation.ui.registerPage.RegisterPage
import com.example.ss_team2.presentation.ui.shop.Shop
import com.example.ss_team2.presentation.ui.taskList.Quest
import com.example.ss_team2.presentation.ui.welcome.Welcome
import com.example.ss_team2.presentation.viewModel.ChatViewModel
import com.example.ss_team2.presentation.viewModel.MapViewModel
import com.example.ss_team2.presentation.viewModel.PostViewModel
import com.example.ss_team2.presentation.viewModel.UserViewModel

@Composable
fun SetupNavGraph(
    mapViewModel: MapViewModel = viewModel(),
    userViewModel: UserViewModel = viewModel(),
    chatViewModel: ChatViewModel = viewModel(),
    postViewModel: PostViewModel = viewModel(),
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.First.route,
        route = ROOT_GRAPH_ROUTE
    ) {
        findNavGraph(
            userViewModel = userViewModel,
            postViewModel = postViewModel,
            navController = navController
        )
        lostNavGraph(
            userViewModel = userViewModel,
            postViewModel = postViewModel,
            navController = navController
        )
        composable(
            route = Screen.First.route
        ) {
            FirstPage(navController = navController)
        }
        composable(
            route = Screen.Register.route
        ) {
            RegisterPage(navController = navController)
        }
        composable(
            route = Screen.Login.route
        ) {
            Welcome(navController = navController)
        }
        composable(
            route = Screen.Home.route
        ) {
            Homepage(navController)
        }
        composable(
            route = Screen.Map.route
        ) {
            MapScreen(
                mapViewModel = mapViewModel,
                userViewModel = userViewModel,
                navController = navController
            )
        }
        composable(
            route = Screen.ChatList.route
        ) {
            ChatList(
                userViewModel = userViewModel,
                chatViewModel = chatViewModel,
                navController = navController
            )
        }
        composable(
            route = Screen.Shop.route
        ) {
            Shop(navController = navController)
        }
        composable(
            route = Screen.ChatRoom.route
        ) {
            Dialog(
                userViewModel = userViewModel,
                chatViewModel = chatViewModel,
                navController = navController
            )
        }
        composable(
            route = Screen.MyPost.route
        ) {
            MyPostApp(
                userViewModel = userViewModel,
                postViewModel = postViewModel,
                navController = navController
            )
        }
        composable(
            route = Screen.Profile.route
        ) {
            MyProfile(
                userViewModel = userViewModel,
                postViewModel = postViewModel,
                navController = navController
            )
        }
        composable(
            route = Screen.Notification.route
        ) {
            Notification(navController = navController)
        }
        composable(
            route = Screen.Quest.route
        ) {
            Quest(navController = navController)
        }
        composable(
            route = Screen.Rank.route
        ) {
            Rank(navController = navController)
        }
        composable(
            route = Screen.Confirmation.route
        ) {
            Confirmation(
                postViewModel = postViewModel,
                navController = navController
            )
        }
        composable(
            route = Screen.EditPost.route,
            arguments = listOf(
                navArgument(WHAT_ARGUMENT_KEY) {
                    type = NavType.StringType
                },
                navArgument(WHERE_ARGUMENT_KEY) {
                    type = NavType.StringType
                },
                navArgument(USERNAME_ARGUMENT_KEY) {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            EditPost(
                navController = navController,
                what = entry.arguments?.getString(WHAT_ARGUMENT_KEY).toString(),
                where = entry.arguments?.getString(WHERE_ARGUMENT_KEY).toString(),
                username = entry.arguments?.getString(USERNAME_ARGUMENT_KEY).toString()
            )
        }
    }
}

