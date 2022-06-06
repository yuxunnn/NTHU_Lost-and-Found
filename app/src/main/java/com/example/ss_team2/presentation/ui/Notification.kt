package com.example.ss_team2

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ss_team2.presentation.ui.DrawableStringPair
import com.example.ss_team2.presentation.ui.homepage.HomepageScreen
import com.example.ss_team2.presentation.ui.utility.BottomBar
import com.example.ss_team2.ui.theme.SSteam2Theme
import com.example.ss_team2.ui.theme.Shapes
import java.lang.ProcessBuilder.Redirect.to

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(238,241,244)
        ),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
            .padding(16.dp)
    )
}

@Composable
fun ReadElement(
    modifier: Modifier=Modifier,
    @StringRes str: Int,
    @DrawableRes itemdrawable: Int,
    @DrawableRes userdrawable: Int,
    time: Int
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Image(
            painter = painterResource(itemdrawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .padding(8.dp)
                .clip(CircleShape)
        )
        Column(modifier = Modifier) {
            Text(
                text = stringResource(id = str),
                fontSize = 12.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = ("$time 分鐘前"),
                color = Color.Gray,
                fontSize = 8.sp
            )
        }
        Spacer(modifier = Modifier.width(180.dp))
        Image(
            painter = painterResource(userdrawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .padding(8.dp)
                .clip(RectangleShape)
        )
    }
}

@Composable
fun NotReadElement(
    modifier: Modifier=Modifier,
    @StringRes str: Int,
    @DrawableRes itemdrawable: Int,
    @DrawableRes userdrawable: Int,
    time: Int
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xE1, 0xE2, 0xfC))
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Image(
            painter = painterResource(itemdrawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .padding(8.dp)
                .clip(CircleShape)
        )
        Column(modifier = Modifier) {
            Text(
                text = stringResource(id = str),
                fontSize = 12.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = ("$time 分鐘前"),
                color = Color.Gray,
                fontSize = 8.sp
            )
        }
        Spacer(modifier = Modifier.width(180.dp))
        Image(
            painter = painterResource(userdrawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .padding(8.dp)
                .clip(RectangleShape)
        )
    }
}

@Composable
fun NotificationLazyScreen(
    modifier: Modifier=Modifier
){
    LazyColumn(
        modifier = Modifier
    ) {
        item{ Text(text = stringResource(id = R.string.NotRead),
            fontWeight = FontWeight.Bold,
            color = Color(0x66,0x70,0x80),
            modifier = Modifier
                .padding(start = 10.dp)
                .padding(4.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Start,
            fontSize = 16.sp
        )
        }
        items(TestData){
                item -> NotReadElement(
            str = item.text,
            itemdrawable = item.drawable,
            userdrawable = item.drawable,
            time = 20
        )
        }
        item{ Text(text = stringResource(id = R.string.Read),
            fontWeight = FontWeight.Bold,
            color = Color(0x66,0x70,0x80),
            modifier = Modifier
                .padding(start = 10.dp)
                .padding(4.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Start,
            fontSize = 16.sp
        )
        }
        items(TestData){
                item -> ReadElement(
            str = item.text,
            itemdrawable = item.drawable,
            userdrawable = item.drawable,
            time = 20
        )
        }
    }
}

@Composable
fun NotificationFinalScreen(modifier: Modifier= Modifier){
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(text = stringResource(id = R.string.Notification),
            fontWeight = FontWeight.Bold,
            color = Color(0x66,0x70,0x80),
            modifier = Modifier
                .paddingFromBaseline(top = 16.dp)
                .padding(8.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 32.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Divider(color = Color(0x66,0x70,0x80), thickness = 1.dp)
        SearchBar()
        NotificationLazyScreen()
    }
}

@Composable
fun Notification(
    navController: NavController
) {
    SSteam2Theme {
        Scaffold(
            bottomBar = { BottomBar(modifier = Modifier, navController) }
        ) {
            NotificationFinalScreen()
        }
    }
}



private val TestData = listOf(
    R.drawable.ic_launcher_background to R.string.ball,
    R.drawable.ic_launcher_background to R.string.ball,
).map { DrawableStringPair(it.first, it.second) }

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    SSteam2Theme {
        NotificationFinalScreen()
    }
}