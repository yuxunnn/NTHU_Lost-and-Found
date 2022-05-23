package com.example.ss_team2.homepage

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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ss_team2.ui.theme.SSteam2Theme

@Composable
fun HomepageScreen(modifier: Modifier) {

    val currentSchool = remember { mutableStateOf(1) }

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
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        Text(
            text = "頂大失物尋寶",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
        )
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
                imageVector = Icons.Default.Send,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .absoluteOffset(y = 100.dp)
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
    ) {
        SchoolFlag(
            school = 1,
            currentSchool = currentSchool.value,
            onClick = { currentSchool.value = 1 }
        )
        SchoolFlag(
            school = 2,
            currentSchool = currentSchool.value,
            onClick = { currentSchool.value = 2 }
        )
        SchoolFlag(
            school = 3,
            currentSchool = currentSchool.value,
            onClick = { currentSchool.value = 3 }
        )
        SchoolFlag(
            school = 4,
            currentSchool = currentSchool.value,
            onClick = { currentSchool.value = 4 }
        )

    }
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .absoluteOffset(y = 220.dp)
            .height(440.dp)
            .fillMaxWidth()
    ) {
        HomepageMainButton(type = 1, onClick = {})
        HomepageMainButton(type = 2, onClick = {})
        HomepageMainButton(type = 3, onClick = {})
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "HomepagePreviewDark",
    showSystemUi = true
)
@Preview(showBackground = true, name = "HomepagePreviewLight", showSystemUi = true)
@Composable
fun HomepagePreview() {
    SSteam2Theme {
        Scaffold { padding ->
            HomepageScreen(modifier = Modifier.padding(padding))
        }
    }
}
