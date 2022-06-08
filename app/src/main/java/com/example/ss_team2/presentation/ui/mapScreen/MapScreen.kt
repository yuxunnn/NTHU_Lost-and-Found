package com.example.ss_team2.presentation.ui.mapScreen

import android.content.res.Configuration
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.viewModel.MapViewModel
import com.example.ss_team2.presentation.ui.homepage.SchoolFlag
import com.example.ss_team2.ui.theme.SSteam2Theme
import com.example.ss_team2.presentation.ui.utility.TopBarButton
import com.example.ss_team2.presentation.viewModel.UserViewModel

@Composable
fun MapScreen(
    modifier: Modifier = Modifier,
    mapViewModel: MapViewModel = viewModel(),
    userViewModel: UserViewModel = viewModel(),
    navController: NavController
) {

    val currentSchool: Int by mapViewModel.school.collectAsState()
    val flagTransition = updateTransition(targetState = currentSchool, label = "Flag indicator")

    val offsetX: List<Dp> = listOf(0.dp, (-60).dp, 0.dp, 60.dp)
    val offsetY: List<Dp> = listOf(20.dp, 0.dp, (-10).dp, 0.dp)
    val flagOffsetX: List<Dp> = listOf(
        flagTransition.animateDp(label = "NTHUX") { school -> offsetX[school] }.value,
        flagTransition.animateDp(label = "NCTUX") { school -> offsetX[(school + 3) % 4] }.value,
        flagTransition.animateDp(label = "NTUX") { school -> offsetX[(school + 2) % 4] }.value,
        flagTransition.animateDp(label = "NCCUX") { school -> offsetX[(school + 1) % 4] }.value,
    )
    val flagOffsetY: List<Dp> = listOf(
        flagTransition.animateDp(label = "NTHUY") { school -> offsetY[school] }.value,
        flagTransition.animateDp(label = "NCTUY") { school -> offsetY[(school + 3) % 4] }.value,
        flagTransition.animateDp(label = "NTUY") { school -> offsetY[(school + 2) % 4] }.value,
        flagTransition.animateDp(label = "NCCUY") { school -> offsetY[(school + 1) % 4] }.value,
    )

    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp)
        ) {
            TopBarButton(
                imageVector = Icons.Default.ArrowBack,
                onClick = {
                    navController.navigate(route = Screen.Home.route) {
                        popUpTo(Screen.First.route) {
                            inclusive = true
                        }
                    }
                }
            )
            Box(modifier = Modifier) {
                repeat(4) {
                    if (it != (currentSchool + 2) % 4) {
                        SchoolFlag(
                            school = it,
                            selected = it == currentSchool,
                            onClick = {
                                mapViewModel.changeSchool(it)
                            },
                            modifier = Modifier.offset(x = flagOffsetX[it], y = flagOffsetY[it])
                        )
                    }
                }
            }
            TopBarButton(
                imageVector = Icons.Default.Storefront,
                onClick = {
                    navController.navigate(route = Screen.Shop.route)
                }
            )
        }

        Divider(
            color = MaterialTheme.colors.onBackground,
            thickness = 2.dp,
            modifier = Modifier.padding(top = 12.dp)
        )

        Map(
            userViewModel = userViewModel,
            mapViewModel = mapViewModel,
            modifier = Modifier
                .height(400.dp)
                .fillMaxWidth()
        )

        Divider(
            color = MaterialTheme.colors.onBackground,
            thickness = 2.dp,
            modifier = Modifier
        )

        MapToolList(
            userViewModel = userViewModel,
            modifier = Modifier
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showSystemUi = true
)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MapPreview() {
    SSteam2Theme {
        Scaffold { padding ->
            MapScreen(
                modifier = Modifier.padding(padding),
                navController = rememberNavController()
            )
        }
    }
}