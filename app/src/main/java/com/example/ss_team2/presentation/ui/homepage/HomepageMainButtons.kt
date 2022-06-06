package com.example.ss_team2.presentation.ui.homepage

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ss_team2.presentation.navigation.FIND_GRAPH_ROUTE
import com.example.ss_team2.presentation.navigation.LOST_GRAPH_ROUTE
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.ui.theme.*

@Composable
fun HomepageMainButtons(
    navController: NavController
){
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
            onClick = {
                navController.navigate(LOST_GRAPH_ROUTE)
            }
        )
        HomepageMainButton(
            text = "撿到",
            color = if (MaterialTheme.colors.isLight) FindHint else FindHintDark,
            onClick = {
                navController.navigate(FIND_GRAPH_ROUTE)
            }
        )
        HomepageMainButton(
            text = "前往地圖",
            color = if (MaterialTheme.colors.isLight) Iris else IrisDark,
            onClick = {
                navController.navigate(route = Screen.Map.route)
            }
        )
    }
}

@Composable
fun HomepageMainButton(
    color: Color,
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        modifier = Modifier
            .width(200.dp)
            .height(92.dp)
            .clip(CutCornerShape(size = 4.dp))
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )
    }
}