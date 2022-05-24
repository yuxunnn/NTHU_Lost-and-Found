package com.example.ss_team2.profile.myprofile

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

@Composable
fun MyProfileScreen(
    username: String,
    modifier: Modifier
) {

    val onNewPost = remember { mutableStateOf(true)}

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 20.dp)
                .fillMaxWidth()
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults
                    .buttonColors(
                        backgroundColor = Color.Transparent,
                        contentColor = MaterialTheme.colors.onBackground
                    ),
                contentPadding = PaddingValues(all = 0.dp),
                shape = RectangleShape,
                modifier = Modifier
                    .size(40.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
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

        ProfileInfo(
            image = R.drawable.my_image,
            schoolName = "國立台灣大學",
            toolAmount = 9,
            point = 520
        )

        ChangeListButton(
            onNewPost = onNewPost.value,
            onClickNew = {
                onNewPost.value = true
            },
            onClickOld = {
                onNewPost.value = false
            }
        )

        if (onNewPost.value) {
            UserPostCardList(
                UserPostData = tempUserPostData,
                modifier = Modifier
            )
        } else {
            UserPostCardList(
                UserPostData = tempUserPostData2,
                modifier = Modifier
            )
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    name = "MyProfilePreviewDark",
    showSystemUi = true
)
@Preview(
    showBackground = true,
    name = "MyProfilePreviewLight",
    showSystemUi = true
)
@Composable
fun MyProfilePreview() {
    SSteam2Theme {
        Scaffold { padding ->
            MyProfileScreen(
                username = "frog_0219",
                modifier = Modifier.padding(padding)
            )
        }
    }
}
