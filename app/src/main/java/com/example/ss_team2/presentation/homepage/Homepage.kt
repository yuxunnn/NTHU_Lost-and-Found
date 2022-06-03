package com.example.ss_team2.presentation.homepage

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
import com.example.ss_team2.presentation.utility.BottomBar
import com.example.ss_team2.presentation.utility.TopBar
import com.example.ss_team2.presentation.utility.TopBarButton
import com.example.ss_team2.ui.theme.*

@Composable
fun HomepageScreen(modifier: Modifier) {

    val currentSchool = remember { mutableStateOf(0) }

    Column {

        TopBar(
            leftButton = {
                TopBarButton(
                    imageVector = Icons.Default.Storefront,
                    onClick = {}
                )
            },
            text = "頂大失物尋寶",
            rightButton = {
                TopBarButton(
                    imageVector = Icons.Default.Message,
                    onClick = {}
                )
            }
        )

        Divider(
            color = MaterialTheme.colors.onBackground,
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

        HomepageMainButtons()
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showSystemUi = true
)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomepagePreview() {
    SSteam2Theme {
        Scaffold(
            bottomBar = { BottomBar(modifier = Modifier) }
        ) { padding ->
            HomepageScreen(modifier = Modifier.padding(padding))
        }
    }
}
