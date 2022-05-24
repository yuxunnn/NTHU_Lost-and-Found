package com.example.ss_team2.profile.yourProfile

import com.example.ss_team2.profile.UserPostCardList
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ss_team2.R
import com.example.ss_team2.ui.theme.SSteam2Theme
import com.example.ss_team2.profile.tempUserPostData

@Composable
fun YourProfileScreen(
    username: String,
    modifier: Modifier
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
    ){
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

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.padding(top = 40.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.your_image),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .width(90.dp)
                    .height(90.dp)
            )
            Column {
                Text(
                    text = "交通大學"
                )
                Text(
                    text = "土木工程學系"
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(120.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 32.dp, bottom = 20.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "9"
                )
                Text(
                    text = "擁有道具"
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "520"
                )
                Text(
                    text = "積分"
                )
            }
        }

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

        Row(
            horizontalArrangement = Arrangement.spacedBy(0.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp)
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
                    .weight(1f)
                    .height(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = null,
                    modifier = Modifier.size(36.dp)
                )
            }

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
                    .weight(1f)
                    .height(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    modifier = Modifier.size(36.dp)
                )
            }
        }
        UserPostCardList(
            UserPostData = tempUserPostData,
            modifier = Modifier
        )
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
