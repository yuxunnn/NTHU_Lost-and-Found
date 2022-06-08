package com.example.ss_team2.presentation.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ss_team2.R
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.ui.theme.SSteam2Theme

@Composable
fun EditPostHomeScreen(
    modifier: Modifier = Modifier,
    @DrawableRes userdrawable: Int,
    @StringRes username: Int,
) {
    Column(
        modifier = Modifier
    ) {
        Text(text = stringResource(id = R.string.EditPost),
            fontWeight = FontWeight.Bold,
            color = Color(0x66,0x70,0x80),
            modifier = Modifier
                .paddingFromBaseline(top = 16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 32.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Divider(color = Color(0x66,0x70,0x80), thickness = 1.dp)
        Spacer(modifier = Modifier.height(16.dp))
        AnonymousUserCard(str = username, drawable = userdrawable)
        EditItemCard()
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            onValueChange = { },
            value = "",
            label = { Text(text = "報酬") },
            modifier = Modifier.padding(start = 40.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "誰可以看到這篇貼文")
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically
        ) {
            val checkedState = remember { mutableStateOf(false) }              //State!!!
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it }
            )
            Text(text = "男生")
        }
        Row(modifier = Modifier,verticalAlignment = Alignment.CenterVertically) {
            val checkedState = remember { mutableStateOf(false) }              //State!!!
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it }
            )
            Text(text = "女生")
        }
    }
}

@Composable
fun EditPostFinalScreen(modifier: Modifier = Modifier,
                           @DrawableRes userdrawable: Int,
                           @StringRes username: Int,
                            navController: NavController
){
    Box(modifier = Modifier.fillMaxSize()){
        EditPostHomeScreen(
            username = username, userdrawable = userdrawable)
        Icon(
            Icons.Filled.Close,
            "",
            modifier = Modifier
                .align(Alignment.TopStart)
                .clickable {
                    navController.popBackStack()
                }
                .padding(16.dp)
        )
        Button(
            onClick = {
                navController.navigate(route = Screen.MyPost.route){
                    popUpTo(Screen.MyPost.route){
                        inclusive = true
                    }
                }
            },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)
        ) {
            Text(text = "完成")
        }
    }
}

@Composable
fun EditPost(
    navController: NavController
){
    EditPostFinalScreen(
        userdrawable = R.drawable.ic_launcher_foreground,
        username = R.string.Finder,
        navController = navController
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview10() {
    SSteam2Theme {
        EditPostFinalScreen(
            userdrawable = R.drawable.ic_launcher_foreground,
            username = R.string.Finder,
            navController = rememberNavController()
        )
    }
}