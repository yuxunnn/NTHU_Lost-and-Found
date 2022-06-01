package com.example.ss_team2.RyanJetpack

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ss_team2.R
import com.example.ss_team2.ui.theme.SSteam2Theme

@Composable
fun WhatAndWhereColElement(
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
            fontSize = 10.sp,
            color = Color(66,70,80),
            fontWeight = FontWeight.Bold
        )
        Surface(
            modifier = modifier.paddingFromBaseline(top = 0.dp, bottom = 20.dp),
            shape = MaterialTheme.shapes.small,
            color = Color(66,70,80)
        ){
            Text(
                text = what,
                modifier = Modifier.padding(6.dp),
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Text(
            text = "Where",
            modifier = Modifier.padding(4.dp),
            fontSize = 10.sp,
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
                modifier = Modifier.padding(6.dp),
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun WhatAndWhereRowElement(
    what: String,
    where: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "What",
            modifier = Modifier.padding(4.dp),
            fontSize = 16.sp,
            color = Color(0x66,0x70,0x80),
            fontWeight = FontWeight.Bold
        )
        Button(
            modifier = modifier.width(80.dp).height(40.dp),
            shape = RoundedCornerShape(15),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor =  Color.White,
                backgroundColor = Color(0x66,0x70,0x80)
            ),
            onClick = {}
        ){
            Text(
                text = what,
                modifier = Modifier,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.width(60.dp))
        Text(
            text = "Where",
            modifier = Modifier.padding(4.dp),
            fontSize = 16.sp,
            color = Color(0x66,0x70,0x80),
            fontWeight = FontWeight.Bold
        )
        Button(
            modifier = modifier.width(80.dp).height(40.dp),
            shape = RoundedCornerShape(15),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor =  Color.White,
                backgroundColor = Color(0x66,0x70,0x80)
            ),
            onClick = {}
        ){
            Text(
                text = where,
                modifier = Modifier,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun PostPreviewElement(
    @DrawableRes drawable: Int,
    @StringRes what: Int,
    @StringRes where: Int,
    @StringRes ItemText: Int,
    modifier: Modifier = Modifier
){
    OutlinedButton(
        modifier = Modifier
            .width(335.dp)
            .height(145.dp),
        shape = RoundedCornerShape(12),
        onClick = {},
        border = BorderStroke(1.dp, Color(0x66,0x70,0x80))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(1.dp),
            horizontalArrangement = Arrangement.spacedBy(36.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(88.dp)
                    .clip(RectangleShape)
            )
            WhatAndWhereColElement( stringResource(id = what), stringResource(id = where))
            Text(
                text = stringResource(id = ItemText),
                fontSize = 10.sp,
                color = Color(66,70,80),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun FindListLazyScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy((8.dp))
    ) {
        items(PostPreviewData){
                item -> PostPreviewElement(drawable = item.drawable, what = item.text, where = item.text, ItemText = item.text)
        }
    }
}

@Composable
fun FindListHomeScreen(modifier: Modifier=Modifier){
    Column(modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.Loser),
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
        Spacer(modifier = Modifier.height(10.dp))
        WhatAndWhereRowElement(
            what = stringResource(id = R.string.ball),
            where = stringResource(id = R.string.home)
        )
        Spacer(modifier = Modifier.height(10.dp))
        FindListLazyScreen()
    }

}

@Composable
fun FindListFinalScreen(modifier: Modifier = Modifier){
    Box(modifier = Modifier.fillMaxSize()){
        FindListHomeScreen()
        OutlinedButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(100.dp)
                .padding(12.dp),
            onClick = {},
            shape = CircleShape,
            colors = ButtonDefaults.outlinedButtonColors(contentColor =  Color.White, backgroundColor = Color(0x78,0x79,0xf1))
        ){
            Icon(Icons.Filled.Add,"")
        }
        OutlinedButton(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .size(100.dp)
                .padding(12.dp),
            onClick = {},
            shape = CircleShape,
            colors = ButtonDefaults.outlinedButtonColors(contentColor =  Color.White, backgroundColor = Color(0x78,0x79,0xf1))
        ){
            Icon(Icons.Filled.Home,"")
        }
    }
}


private val PostPreviewData = listOf(
    R.drawable.ic_launcher_background to R.string.app_name,
    R.drawable.ic_launcher_foreground to R.string.ball,
    R.drawable.umbrella to R.string.home,
    R.drawable.umbrella to R.string.home,
    R.drawable.umbrella to R.string.home
).map { DrawableStringPair(it.first, it.second) }
data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SSteam2Theme {
        FindListFinalScreen()
    }
}