package com.example.ss_team2.profile.yourProfile

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ss_team2.R
import com.example.ss_team2.profile.*
import com.example.ss_team2.ui.theme.SSteam2Theme
import com.example.ss_team2.utility.TopBarButton
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun YourProfileScreen(
    username: String,
    modifier: Modifier
) {

    val pagerState = rememberPagerState(pageCount = 2)
    val scope = rememberCoroutineScope()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp)
        ) {
            TopBarButton(
                imageVector = Icons.Default.ArrowBack,
                onClick = {}
            )
            Text(
                text = username,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.size(32.dp))
        }

        ProfileInfo(
            image = R.drawable.your_image,
            schoolName = "國立交通大學",
            toolAmount = 2,
            point = 90
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {},
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
                border = BorderStroke(width = 1.dp, color = MaterialTheme.colors.onBackground),
                modifier = Modifier
                    .width(140.dp)
                    .height(40.dp)
                    .clip(CutCornerShape(size = 4.dp))
            ) {
                Text(
                    text = "封鎖",
                    fontWeight = FontWeight.Bold,
                    color = Color.Red,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
            Button(
                onClick = {},
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
                border = BorderStroke(width = 1.dp, color = MaterialTheme.colors.onBackground),
                modifier = Modifier
                    .width(140.dp)
                    .height(40.dp)
                    .clip(CutCornerShape(size = 4.dp))
            ) {
                Text(
                    text = "傳送訊息",
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
        }

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
                modifier = Modifier
            )
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    name = "YourProfilePreviewDark",
    showSystemUi = true
)
@Preview(
    showBackground = true,
    name = "YourProfilePreviewLight",
    showSystemUi = true
)
@Composable
fun YourProfilePreview() {
    SSteam2Theme {
        Scaffold { padding ->
            YourProfileScreen(
                username = "ryan_910107",
                modifier = Modifier.padding(padding)
            )
        }
    }
}
