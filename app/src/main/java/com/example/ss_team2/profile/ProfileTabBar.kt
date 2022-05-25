package com.example.ss_team2.profile

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProfileTabBar(
    tabPage: Int,
    onTabSelected: (tabPage: Int) -> Unit
) {

    TabRow(
        selectedTabIndex = tabPage,
        indicator = { tabPositions ->
            ChangeProfileTabIndicator(tabPositions, tabPage)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
    ) {
        ProfileTab(
            color = if (tabPage == 0) MaterialTheme.colors.primary else Color.LightGray,
            imageVector = Icons.Default.List,
            onClick = { onTabSelected(0) },
            modifier = Modifier
        )
        ProfileTab(
            color = if (tabPage == 1) MaterialTheme.colors.primary else Color.LightGray,
            imageVector = Icons.Default.Star,
            onClick = { onTabSelected(1) },
            modifier = Modifier
        )
    }
}

@Composable
fun ChangeProfileTabIndicator(
    tabPositions: List<TabPosition>,
    tabPage: Int
) {
    val transition = updateTransition(tabPage, label = "Tab indicator")
    val indicatorLeft by transition.animateDp(label = "Indicator left") { page ->
        tabPositions[page].left
    }
    val indicatorRight by transition.animateDp(label = "Indicator right") { page ->
        tabPositions[page].right
    }

    Divider(
        thickness = 2.dp,
        color = MaterialTheme.colors.primary,

        modifier = Modifier
            .offset(x = indicatorLeft)
            .wrapContentSize(align = Alignment.BottomStart)
            .width(indicatorRight - indicatorLeft)
            .border(BorderStroke(2.dp, MaterialTheme.colors.primary))
    )
}


@Composable
fun ProfileTab(
    color: Color,
    imageVector: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults
            .buttonColors(
                backgroundColor = MaterialTheme.colors.background,
                contentColor = color
            ),
        contentPadding = PaddingValues(all = 0.dp),
        shape = RectangleShape,
        modifier = modifier
            .height(48.dp)
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            modifier = Modifier.size(36.dp)
        )
    }
}