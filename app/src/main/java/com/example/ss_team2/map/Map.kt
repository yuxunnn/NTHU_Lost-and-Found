package com.example.ss_team2.map

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ss_team2.R
import com.example.ss_team2.homepage.SchoolFlag
import com.example.ss_team2.ui.theme.SSteam2Theme

@Composable
fun MapScreen(
    modifier: Modifier
) {

    val currentSchool = remember { mutableStateOf(1) }
    Column {
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

            Row {
                SchoolFlag(
                    school = if (currentSchool.value - 1 == 0) 4 else currentSchool.value - 1,
                    currentSchool = currentSchool.value,
                    onClick = {
                        currentSchool.value =
                            if (currentSchool.value - 1 == 0) 4 else currentSchool.value - 1
                    },
                    modifier = Modifier
                )
                SchoolFlag(
                    school = currentSchool.value,
                    currentSchool = currentSchool.value,
                    onClick = { },
                    modifier = Modifier.offset(y = 20.dp)
                )
                SchoolFlag(
                    school = if (currentSchool.value + 1 > 4) 1 else currentSchool.value + 1,
                    currentSchool = currentSchool.value,
                    onClick = {
                        currentSchool.value =
                            if (currentSchool.value + 1 > 4) 1 else currentSchool.value + 1
                    },
                    modifier = Modifier
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
                    .size(32.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        Divider(
            color = MaterialTheme.colors.onBackground,
            thickness = 2.dp,
            modifier = Modifier.padding(top = 12.dp)
        )

        Map(modifier = Modifier)

        Divider(
            color = MaterialTheme.colors.onBackground,
            thickness = 2.dp,
            modifier = Modifier
        )
    }
}

@Composable
fun Map(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.umbrella1),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .height(300.dp)
            .fillMaxWidth()
    )
}


@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "MapPreviewDark",
    showSystemUi = true
)
@Preview(
    showBackground = true,
    name = "MapPreviewLight",
    showSystemUi = true
)
@Composable
fun MapPreview() {
    SSteam2Theme {
        Scaffold { padding ->
            MapScreen(
                modifier = Modifier.padding(padding)
            )
        }
    }
}