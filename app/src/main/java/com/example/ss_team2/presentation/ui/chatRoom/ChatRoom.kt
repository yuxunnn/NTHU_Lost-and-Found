package com.example.ss_team2.presentation.ui.chatRoom

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ss_team2.R
import com.example.ss_team2.presentation.viewModel.ChatViewModel
import com.example.ss_team2.presentation.viewModel.UserViewModel
import com.example.ss_team2.ui.theme.SSteam2Theme
import com.example.ss_team2.ui.theme.TextGray
import kotlinx.coroutines.launch


@Composable
fun Dialog(
    userViewModel: UserViewModel,
    chatViewModel: ChatViewModel,
    navController: NavController
) {

    var myTextInput by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val user by userViewModel.user.collectAsState()
    val otherUser by userViewModel.otherUser.collectAsState()
    val chat by chatViewModel.chat.collectAsState()

    Column {
        Avatar(
            userViewModel = userViewModel,
            navController = navController
        )
        Divider(startIndent = 0.dp, thickness = 3.dp, color = Color.Black)
        DialogSurface(
            listState = listState,
            chatViewModel = chatViewModel,
            userViewModel = userViewModel,
            modifier = Modifier.weight(1f)
        )
        TextInput(
            myTextInput = myTextInput,
            onValueChange = { myTextInput = it },
            onSend = {
                if (myTextInput != "") {
                    chatViewModel.createChat(
                        sender = otherUser.userName,
                        receiver = user.userName,
                        message = myTextInput
                    )
                    myTextInput = ""
                    coroutineScope.launch {
                        listState.animateScrollToItem(index = chat.size)
                    }
                }
            }
        )
    }
}


@Composable
fun Avatar(
    userViewModel: UserViewModel,
    navController: NavController
) {

    val otherUser by userViewModel.otherUser.collectAsState()

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = TextGray,
            modifier = Modifier
                .size(40.dp)
                .clickable { navController.popBackStack() }
        )
        Image(
            painter = painterResource(R.drawable.default_avatar),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(text = otherUser.userName, fontSize = 24.sp)

    }
}


@Composable
fun DialogSurface(
    listState: LazyListState,
    chatViewModel: ChatViewModel,
    userViewModel: UserViewModel,
    modifier: Modifier
) {

    val chat by chatViewModel.chat.collectAsState()
    val user by userViewModel.user.collectAsState()

    LazyColumn(
        state = listState,
        modifier = modifier
    ) {
        items(chat) { item ->
            MessageCard(
                sender = item.send,
                message = item.message,
                myName = user.userName
            )
        }
    }
}

@Composable
fun MessageCard(
    sender: String,
    message: String,
    myName: String
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (sender != myName) Arrangement.Start else Arrangement.End
    ) {
        Card(
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 16.dp)
                .widthIn(max = 250.dp),
            elevation = 3.dp,
            backgroundColor = Color.White
        ) {
            Text(
                modifier = Modifier.padding(12.dp),
                text = message
            )
        }
    }
}


@Composable
fun TextInput(
    myTextInput: String,
    onValueChange: (String) -> Unit,
    onSend: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        Alignment.Bottom
    ) {
        TextField(
            value = myTextInput,
            onValueChange = onValueChange,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = null,
                    modifier = Modifier.clickable { onSend() }
                )
            }
        )
    }
}