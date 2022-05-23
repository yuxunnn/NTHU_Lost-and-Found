package com.example.ss_team2.profile.yourProfile

import com.example.ss_team2.profile.UserPostCardList
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ss_team2.ui.theme.SSteam2Theme
import com.example.ss_team2.profile.tempUserPostData

@Composable
fun YourProfileScreen(
    username: String,
    modifier: Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults
                .buttonColors(
                    backgroundColor = MaterialTheme.colors.background,
                    contentColor = MaterialTheme.colors.onBackground
                ),
            contentPadding = PaddingValues(all = 0.dp),
            shape = RectangleShape,
            modifier = Modifier
                .size(32.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        Text(
            text = username,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.size(32.dp))
    }

    UserPostCardList(
        UserPostData = tempUserPostData,
        modifier = modifier.absoluteOffset(y = 320.dp)
    )
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    name = "MyProfilePreviewDark",
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
