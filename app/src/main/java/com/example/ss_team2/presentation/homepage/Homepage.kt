package com.example.ss_team2.presentation.homepage

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ss_team2.presentation.utility.BottomBar
import com.example.ss_team2.presentation.utility.TopBarButton
import com.example.ss_team2.ui.theme.*

@Composable
fun HomepageScreen(modifier: Modifier) {

    val currentSchool = remember { mutableStateOf(0) }

    Column {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp)
        ) {
            TopBarButton(
                imageVector = Icons.Default.ShoppingCart,
                onClick = {}
            )
            Text(
                text = "頂大失物尋寶",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
            )
            TopBarButton(
                imageVector = Icons.Default.Send,
                onClick = {}
            )
        }

        Divider(
            color = MaterialTheme.colors.onBackground,
            thickness = 2.dp,
            modifier = Modifier
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
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
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .height(440.dp)
                .fillMaxWidth()
        ) {
            HomepageMainButton(
                text = "遺失",
                color = if (MaterialTheme.colors.isLight) LostHint else LostHintDark,
                onClick = {}
            )
            HomepageMainButton(
                text = "撿到",
                color = if (MaterialTheme.colors.isLight) FindHint else FindHintDark,
                onClick = {}
            )
            HomepageMainButton(
                text = "前往地圖",
                color = if (MaterialTheme.colors.isLight) Iris else IrisDark,
                onClick = {}
            )
        }
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
