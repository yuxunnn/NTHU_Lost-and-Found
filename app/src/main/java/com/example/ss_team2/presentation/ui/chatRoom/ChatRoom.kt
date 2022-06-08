package com.example.ss_team2.presentation.ui.chatRoom

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ss_team2.R
import com.example.ss_team2.ui.theme.SSteam2Theme
import com.example.ss_team2.ui.theme.TextGray

@Composable
fun Dialog(navController: NavController) {
    Column {
        TheFriend(Name = "yuxun", navController)
        Divider(startIndent = 0.dp, thickness = 2.dp, color = TextGray)
        DialogSurface()
        //TextInput()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun DialogPreview(){
    SSteam2Theme {
        Dialog(navController = rememberNavController())
    }
}

@Composable
fun TheFriend(
    Name : String,
    navController: NavController
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 20.dp)
            .fillMaxWidth()
    ){
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

        Image(
            painter = painterResource(R.drawable.my_image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )

        Column(
            modifier = Modifier
                .height(50.dp)
                .padding(start = 15.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = Name
            )
        }

    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun TheFriendPreview(){
    SSteam2Theme() {
        TheFriend("hui._.yuiui", navController = rememberNavController())
    }
}

@Composable
fun MsgCard(
    msg: String,
    sender: String,
    myName: String
){
    val Sender = sender

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (sender != myName) Arrangement.Start else Arrangement.End
    ) {
        Card(
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 16.dp)
                .widthIn(max = 250.dp),
            elevation = 3.dp,    //shadow
            backgroundColor = Color.White
        ) {
            Text(
                modifier = Modifier.padding(12.dp),
                text = msg
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun MsgCardPreview(){
    SSteam2Theme() {
        MsgCard("哈囉","huiui","using")
    }
}

//for test
data class Message(
    val sender: String,
    val msgContent: String
)

private val MessageList = listOf(
    Message("hui._.yuiui","哈囉"),
    Message("using", "嗨")
)

@Composable
fun DialogSurface(){
    Surface(
        modifier = Modifier.fillMaxHeight()
    ){
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ){
            items(MessageList){ item ->
                MsgCard(sender = item.sender,msg = item.msgContent, myName = "using")
            }
        }
        TextInput()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun DialogSurfacePreview(){
    SSteam2Theme {
        DialogSurface()
    }
}

@Composable
fun TextInput(){

    var myTextInput by remember { mutableStateOf("") }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        Alignment.Bottom
    ){
        TextField(
            value = myTextInput,
            onValueChange = { myTextInput = it },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = null,
                    Modifier.clickable(){}

                )
            }
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun TextInputPreview(){
    SSteam2Theme {
        TextInput()
    }
}