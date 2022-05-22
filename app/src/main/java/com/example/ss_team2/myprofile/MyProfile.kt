package com.example.ss_team2.myprofile

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ss_team2.ui.theme.SSteam2Theme
import com.example.ss_team2.R

@Composable
fun UserPostCardList(UserPostData: List<Post>, modifier: Modifier) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 20.dp),
        modifier = modifier
    ) {
        items(UserPostData) { item ->
            UserPostCard(
                type = item.type,
                image = item.image,
                what = item.what,
                where = item.where,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun UserPostCard(
    type: Int,
    @DrawableRes image: Int,
    what: List<String>,
    where: List<String>,
    modifier: Modifier
) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {}
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(72.dp)
            )
            PostInfo(
                text = "What",
                tags = what,
                modifier = Modifier.offset(x = 12.dp)
            )
            PostInfo(
                text = "Where",
                tags = where,
                modifier = Modifier.offset(x = 60.dp)
            )
        }
    }
    PostTypeHint(
        type = type,
        modifier = modifier
            .offset(x = (-10).dp, y = (-82).dp)
            .size(20.dp)
    )
}

@Composable
fun PostInfo(
    text: String,
    tags: List<String>,
    modifier: Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = text,
            style = MaterialTheme.typography.h6,
            fontSize = 8.sp,
            modifier = Modifier
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            items(tags) { location ->
                Text(
                    text = location,
                    style = MaterialTheme.typography.h6,
                    fontSize = 12.sp,
                )
            }
        }
    }
}

@Composable
fun PostTypeHint(
    type: Int,
    modifier: Modifier
) {
    val color: Color = if (type == 1) Color.Green else Color.Red
    val text: String = if (type == 1) "撿" else "遺"

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.background(color = color, shape = CircleShape)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 10.sp,
            textAlign = TextAlign.Center
        )
    }
}

data class Post(val type: Int, val image: Int, val what: List<String>, val where: List<String>)

private val tempUserPostData: List<Post> = listOf(
    Post(
        type = 1,
        image = R.drawable.umbrella1,
        what = listOf("雨傘"),
        where = listOf("資電館")
    ),
    Post(
        type = 2,
        image = R.drawable.umbrella2,
        what = listOf("傘"),
        where = listOf("資電館", "小吃部", "碩齋")
    )
)

@Composable
fun MyProfileScreen(modifier: Modifier) {
    UserPostCardList(
        UserPostData = tempUserPostData,
        modifier = Modifier.absoluteOffset(x = 8.dp, y = 320.dp)
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun UserPostCardPreview() {
    SSteam2Theme {
        UserPostCardList(
            UserPostData = tempUserPostData,
            modifier = Modifier
        )
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun MyProfilePreview() {
    SSteam2Theme() {
        Scaffold { padding ->
            MyProfileScreen(modifier = Modifier.padding(padding))
        }
    }
}
