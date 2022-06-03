package com.example.ss_team2.presentation.ui.chatList

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

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ss_team2.R
import com.example.ss_team2.ui.theme.SSteam2Theme

@Composable
fun ChatList () {
    Column {
        Title()
        Divider(startIndent = 0.dp, thickness = 3.dp, color = Color.Black)
        SearchBar()
        ChatRooms()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun ChatListPreview(){
    SSteam2Theme() {
        ChatList()
    }
}

@Composable
fun Title(
    modifier: Modifier = Modifier,
){
    Row(
        Modifier.fillMaxWidth(),
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBackIos,
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .padding(start = 8.dp)
                .clickable() {}
        )
        Text(
            text = "聊天室",
            fontSize = 36.sp,
            modifier = Modifier.padding(start = 85.dp,end = 16.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun TitlePreview() {
    SSteam2Theme { Title() }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    var SearchingText by remember { mutableStateOf("") }
    // Implement composable here
    Row(
        Modifier.fillMaxWidth().padding(20.dp),
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
    newestTime: String
){
    Surface(
        modifier = Modifier.fillMaxWidth()
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
                        fontSize = 25.sp
                    )
                }
                Row(){
                    Text(
                        text = firstSentence
                    )
                    Spacer(Modifier.width(5.dp))
                    Text(
                        text =  newestTime
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
            "10:11"
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
){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        items(FriendList){ item ->
            ChatRoom(firstSentence = item.LastSentence, friendname = item.Name, newestTime = item.Time)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun ChatRoomsPreview(){
    SSteam2Theme {
        ChatRooms()
    }
}