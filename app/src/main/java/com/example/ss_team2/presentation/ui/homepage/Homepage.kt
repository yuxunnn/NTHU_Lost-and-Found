package com.example.ss_team2.presentation.ui.homepage

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.ui.utility.BottomBar
import com.example.ss_team2.presentation.ui.utility.TopBar
import com.example.ss_team2.presentation.ui.utility.TopBarButton
import com.example.ss_team2.ui.theme.*

@Composable
fun HomepageScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    val currentSchool = remember { mutableStateOf(0) }

    Column {

        TopBar(
            leftButton = {
                TopBarButton(
                    imageVector = Icons.Default.Storefront,
                    onClick = {
                        navController.navigate(route = Screen.Shop.route)
                    }
                )
            },
            text = "頂大失物尋寶",
            rightButton = {
                TopBarButton(
                    imageVector = Icons.Default.Message,
                    onClick = {
                        navController.navigate(route = Screen.ChatList.route)
                    }
                )
            }
        )

        Divider(
            color = TextGray,
            thickness = 2.dp,
            modifier = Modifier
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 20.dp)
                .fillMaxWidth()
        ) {
            repeat(4) {
                SchoolFlag(
                    school = it,
                    selected = currentSchool.value == it,
                    onClick = { currentSchool.value = it },
                    modifier = Modifier
                )
            }
        }

        HomepageMainButtons(navController = navController)
    }
}

@Composable
fun Homepage(
    navController: NavController
) {
    SSteam2Theme {
        Scaffold(
            bottomBar = { BottomBar(modifier = Modifier, navController) }
        ) { padding ->
            HomepageScreen(modifier = Modifier.padding(padding), navController = navController)
        }
    }
}
