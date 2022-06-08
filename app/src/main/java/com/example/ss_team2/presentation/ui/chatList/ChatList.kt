package com.example.ss_team2.presentation.ui.chatList

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ss_team2.R
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.ui.theme.SSteam2Theme
import com.example.ss_team2.ui.theme.TextGray

@Composable
fun ChatList (
    navController: NavController
) {
    Column {
        Title(navController = navController)
        Divider(startIndent = 0.dp, thickness = 2.dp, color = TextGray)
        SearchBar()
        ChatRooms(navController = navController)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun ChatListPreview(){
    SSteam2Theme() {
        ChatList(navController = rememberNavController())
    }
}

@Composable
fun Title(
    modifier: Modifier = Modifier,
    navController: NavController
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBackIos,
            contentDescription = null,
            tint = TextGray,
            modifier = Modifier
                .size(32.dp)
                .padding(start = 8.dp)
                .clickable() {
                    navController.popBackStack()
                }
        )
        Text(
            text = "聊天室",
            fontSize = 32.sp,
            modifier = Modifier.padding(start = 70.dp,end = 128.dp),
            fontWeight = FontWeight.Bold,
            color = TextGray,
        )
    }
}


@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    var SearchingText by remember { mutableStateOf("") }
    // Implement composable here
    Row(
        Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        TextField(
            value = SearchingText,
            onValueChange = { SearchingText = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
            },
            shape = MaterialTheme.shapes.small, // the round corner
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface
            ),
            modifier = modifier
                .width(320.dp)
                .heightIn(min = 56.dp)
                .padding(start = 8.dp, end = 8.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun SearchBarPreview(){
    SSteam2Theme() {
        SearchBar()
    }
}

@Composable
fun ChatRoom(
    firstSentence : String,
    friendname : String,
    newestTime: String,
    navController: NavController
){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate(route = Screen.ChatRoom.route)
            }
    ) {
        Row() {
            Image(
                painter = painterResource(R.drawable.defaultpicture),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(88.dp)
                    .clip(CircleShape)
            )

            Column(
                modifier = Modifier
                    .padding(start = 20.dp)
                    .height(88.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(){
                    Text(
                        text = friendname,
                        fontSize = 25.sp,
                        color = TextGray,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(){
                    Text(
                        text = firstSentence,
                        color = TextGray,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.width(5.dp))
                    Text(
                        text =  newestTime,
                        color = TextGray,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun ChatRoomPreview(){
    SSteam2Theme() {
        ChatRoom(
            "你好",
            "notyuxun",
            "10:11",
            navController = rememberNavController()
        )
    }
}

//for test
data class Friend(val Name: String, val LastSentence: String,val Time: String)

private val FriendList: List<Friend> = listOf(
    Friend("notyuxun","你好","10:15"),
    Friend("hui._.yuiui","欸我們去交大工程一館塗鴉","10:05"),
    Friend("usingya","資電三樓有一把傘很像你的","7:26"),
    Friend("ryan910707","你丟的傘還有甚麼其他特徵嗎","4:02"),
    Friend("dasbd72","感謝你幫我找回學生證","23:11"),

)

@Composable
fun ChatRooms(
    modifier: Modifier = Modifier,
    navController: NavController
){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        items(FriendList){ item ->
            ChatRoom(
                firstSentence = item.LastSentence,
                friendname = item.Name,
                newestTime = item.Time,
                navController = navController
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun ChatRoomsPreview(){
    SSteam2Theme {
        ChatRooms(navController = rememberNavController())
    }
}