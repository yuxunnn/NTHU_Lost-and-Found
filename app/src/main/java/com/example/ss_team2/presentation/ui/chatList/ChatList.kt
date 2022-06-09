package com.example.ss_team2.presentation.ui.chatList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ss_team2.R
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.ui.utility.TopBar
import com.example.ss_team2.presentation.ui.utility.TopBarButton
import com.example.ss_team2.presentation.viewModel.ChatViewModel
import com.example.ss_team2.presentation.viewModel.UserViewModel
import com.example.ss_team2.ui.theme.SSteam2Theme
import com.example.ss_team2.ui.theme.TextGray

@Composable
fun ChatList(
    userViewModel: UserViewModel,
    chatViewModel: ChatViewModel,
    navController: NavController,
) {

    var searchingText by remember { mutableStateOf("") }

    Column {
        TopBar(
            leftButton = {
                TopBarButton(imageVector = Icons.Default.ArrowBack,
                    onClick = { navController.popBackStack() }
                )
            },
            text = "聊天室",
            rightButton = {
                Spacer(modifier = Modifier.size(32.dp))
            }
        )
        Divider(startIndent = 0.dp, thickness = 3.dp, color = Color.Black)
        SearchBar(
            searchingText = searchingText,
            onValueChange = { searchingText = it }
        )
        ChatRooms(
            userViewModel = userViewModel,
            chatViewModel = chatViewModel,
            navController = navController
        )
    }
}

@Composable
fun ChatRooms(
    userViewModel: UserViewModel,
    chatViewModel: ChatViewModel,
    navController: NavController
) {

    val chats by chatViewModel.chats.collectAsState()

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(chats) { chat ->
            ChatRoom(
                friendName = chat.send,
                lastMessage = chat.message,
                onClick = {
                    userViewModel.getOtherUserByName(chat.send)
                    chatViewModel.chatsByReceiveAndSend(chat.receive, chat.send)
                    navController.navigate(route = Screen.ChatRoom.route)
                }
            )
        }
    }
}


@Composable
fun ChatRoom(
    friendName: String,
    lastMessage: String,
    onClick: () -> Unit,
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.default_avatar),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .offset(x = 12.dp)
                    .size(72.dp)
                    .clip(CircleShape)
                    .background(color = MaterialTheme.colors.background)
            )

            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .padding(start = 40.dp)
                    .height(88.dp)
            ) {
                Text(
                    text = friendName,
                    fontSize = 18.sp
                )
                Text(text = lastMessage)
            }
        }
    }
}


@Composable
fun SearchBar(
    searchingText: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        TextField(
            value = searchingText,
            onValueChange = onValueChange,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier.size(36.dp)
                )
            },
            shape = MaterialTheme.shapes.small,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface
            ),
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp)
                .padding(start = 8.dp, end = 8.dp)
        )
    }
}