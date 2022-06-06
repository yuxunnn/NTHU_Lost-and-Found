package com.example.ss_team2.presentation.ui.profile

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ss_team2.domain.model.User
import com.example.ss_team2.domain.model.userFrog
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.ui.homepage.HomepageScreen
import com.example.ss_team2.ui.theme.SSteam2Theme
import com.example.ss_team2.presentation.ui.utility.BottomBar
import com.example.ss_team2.presentation.ui.utility.TopBar
import com.example.ss_team2.presentation.ui.utility.TopBarButton
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyProfileScreen(
    user: User,
    modifier: Modifier = Modifier,
    navController: NavController
) {

    val pagerState = rememberPagerState(pageCount = 2)
    val scope = rememberCoroutineScope()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        TopBar(
            leftButton = {
                TopBarButton(
                    imageVector = Icons.Default.Storefront,
                    onClick = {
                        navController.navigate(route = Screen.Shop.route)
                    }
                )
            },
            text = user.username,
            rightButton = {
                Spacer(modifier = Modifier.size(32.dp))
            }
        )

        PersonalInfo(
            image = user.userImage,
            schoolName = user.userSchool,
            toolAmount = user.userToolAmount,
            point = user.userPoint
        )

        ProfileTabBar(
            tabPage = pagerState.currentPage,
            onTabSelected = {
                scope.launch {
                    pagerState.animateScrollToPage(it)
                }
            }
        )

        HorizontalPager(state = pagerState) { index ->
            UserPostCardList(
                tabPage = index,
                userPostList = user.userPostList,
                modifier = Modifier,
                navController = navController
            )
        }
    }
}


@Composable
fun MyProfile(
    navController: NavController
) {
    SSteam2Theme {
        Scaffold(
            bottomBar = { BottomBar(modifier = Modifier, navController) }
        ) {
            MyProfileScreen(
                user = userFrog,
                modifier = Modifier,
                navController = navController
            )
        }
    }
}


@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    showSystemUi = true
)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyProfilePreview() {
    SSteam2Theme {
        Scaffold(
            bottomBar = { BottomBar(modifier = Modifier, navController = rememberNavController()) }
        ) { padding ->
            MyProfileScreen(
                user = userFrog,
                modifier = Modifier.padding(padding),
                navController = rememberNavController()
            )
        }
    }
}
