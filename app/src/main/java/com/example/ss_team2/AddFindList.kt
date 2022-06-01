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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ss_team2.ui.theme.SSteam2Theme
import com.example.ss_team2.ui.theme.Shapes
import java.lang.ProcessBuilder.Redirect.to

@Composable
fun AnonymousUserCard(
    modifier: Modifier=Modifier,
    @StringRes str: Int,
    @DrawableRes drawable: Int
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .padding(8.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(id = str),
            fontSize = 12.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.width(60.dp))
        Text(
            text = ("匿名"),
            color = Color(0x66,0x70,0x80),
            fontSize = 8.sp
        )
        val checkedState = remember { mutableStateOf(false) }
        Switch(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it },
            colors = SwitchDefaults.colors(checkedThumbColor = Color.DarkGray,
                uncheckedThumbColor = Color.DarkGray,
                checkedTrackColor = Color.Blue,
                uncheckedTrackColor = Color.Blue,)
        )
    }
}

@Composable
fun EditItemCard(
    modifier: Modifier=Modifier
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .background(Color(220, 220, 220)),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(36.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.defaultpicture),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(160.dp)
                .width(160.dp)
                .clip(RectangleShape)
                .padding(4.dp)
                .clickable {}
        )
        Column(modifier = Modifier) {
            WhatAndWhereColElementClickable(what = stringResource(id = R.string.Click),
                where = stringResource(id = R.string.Click))
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = stringResource(id = R.string.description), fontSize = 12.sp)
        }

    }
}

@Composable
fun WhatAndWhereColElementClickable(
    what: String,
    where: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "What",
            modifier = Modifier.padding(4.dp),
            fontSize = 12.sp,
            color = Color(66,70,80),
            fontWeight = FontWeight.Bold
        )
        Surface(
            modifier = modifier,
            shape = MaterialTheme.shapes.small,
            color = Color(66,70,80)
        ){
            Text(
                text = what,
                modifier = Modifier
                    .padding(6.dp)
                    .clickable { },
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Text(
            text = "Where",
            modifier = Modifier.padding(4.dp),
            fontSize = 12.sp,
            color = Color(66,70,80),
            fontWeight = FontWeight.Bold
        )
        Surface(
            modifier = modifier,
            shape = MaterialTheme.shapes.small,
            color = Color(66,70,80)
        ){
            Text(
                text = where,
                modifier = Modifier
                    .padding(6.dp)
                    .clickable { },
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun AddFindListHomeScreen(
    modifier: Modifier = Modifier,
    @DrawableRes userdrawable: Int,
    @StringRes username: Int
) {
    Column(
        modifier = Modifier
    ) {
        Text(text = stringResource(id = R.string.AddFindList),
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
    }
}


@Composable
fun AddFindListFinalScreen(modifier: Modifier = Modifier,
                           @DrawableRes userdrawable: Int,
                           @StringRes username: Int,
                           time: Int
){
    Box(modifier = Modifier.fillMaxSize()){
        AddFindListHomeScreen(
            username = username, userdrawable = userdrawable)
        Icon(
            Icons.Filled.Close,
            "",
            modifier = Modifier
                .align(Alignment.TopStart)
                .clickable {}
                .padding(16.dp)
        )
        Button(
            onClick = {},
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)
        ) {
            Text(text = "發布")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview8() {
    SSteam2Theme {
        AddFindListFinalScreen(userdrawable = R.drawable.ic_launcher_foreground, username = R.string.Finder, time = 20)
    }
}