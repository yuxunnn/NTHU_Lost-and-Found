package com.example.ss_team2.presentation.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ss_team2.R
import com.example.ss_team2.presentation.ui.othersPost.PostItemCard
import com.example.ss_team2.presentation.viewModel.PostViewModel

@Composable
fun ConfirmationHomeScreen(
    postViewModel: PostViewModel
) {

    val post by postViewModel.post.collectAsState()

    Column(
        modifier = Modifier
    ) {
        Text(
            text = stringResource(id = R.string.Confirm),
            fontWeight = FontWeight.Bold,
            color = Color(0x66, 0x70, 0x80),
            modifier = Modifier
                .paddingFromBaseline(top = 16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 32.sp
        )
        Divider(
            color = Color(0x66, 0x70, 0x80),
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        PostItemCard(
            postViewModel = postViewModel
        )
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "請選擇積分給予有協助的對象",
                modifier = Modifier.padding(8.dp)
            )
            Spacer(modifier = Modifier.width(108.dp))
            Text(text = " ${post.rewardCoin}", modifier = Modifier.padding(8.dp))
        }
        ConfirmationLazyScreen()
    }
}


@Composable
fun ConfirmationFinalScreen(
    modifier: Modifier = Modifier,
    postViewModel: PostViewModel,
    navController: NavController
) {

    Box(modifier = Modifier.fillMaxSize()) {
        ConfirmationHomeScreen(postViewModel = postViewModel)
        Icon(
            Icons.Filled.ArrowBack,
            "",
            modifier = Modifier
                .align(Alignment.TopStart)
                .clickable {}
                .padding(16.dp)
        )
        Button(
            onClick = {
                navController.popBackStack()
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
fun HelpElement(
    modifier: Modifier = Modifier,
    money: Int,
    @StringRes username: Int,
    @DrawableRes drawable: Int,
) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val checkedState = remember { mutableStateOf(false) }              //State!!!
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it }
        )
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
            text = stringResource(id = username),
            fontSize = 12.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Text(text = "+ $money$")
    }
}

@Composable
fun ConfirmationLazyScreen(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = Modifier.padding(20.dp)
    ) {
//        items(TestData) { item ->
//            HelpElement(username = item.text, drawable = item.drawable, money = 20)
//        }
    }
}


@Composable
fun Confirmation(
    postViewModel: PostViewModel,
    navController: NavController
) {
    ConfirmationFinalScreen(
        postViewModel = postViewModel,
        navController = navController
    )
}