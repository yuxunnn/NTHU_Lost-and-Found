package com.example.ss_team2.presentation.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.ss_team2.presentation.viewModel.HelperViewModel
import com.example.ss_team2.presentation.viewModel.PostViewModel
import com.example.ss_team2.presentation.viewModel.UserViewModel
import com.example.ss_team2.ui.theme.TextGray


@Composable
fun Confirmation(
    modifier: Modifier = Modifier,
    helperViewModel: HelperViewModel,
    userViewModel: UserViewModel,
    postViewModel: PostViewModel,
    navController: NavController
) {

    val post by postViewModel.post.collectAsState()
    val user by userViewModel.user.collectAsState()

    Column(
        modifier = Modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 20.dp)
                .fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = null,
                tint = TextGray,
                modifier = Modifier
                    .size(40.dp)
                    .clickable(
                        onClick = {
                            navController.popBackStack()
                        }
                    )
            )
            Text(
                text = stringResource(id = R.string.Confirm),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier,
                color = TextGray
            )
            Button(
                onClick = {
                    postViewModel.donePost(post.postId)
                    userViewModel.updateCoin(user.userName, -post.rewardCoin)
                    navController.popBackStack()
                },
                modifier = Modifier
            ) {
                Text(text = "完成")
            }
        }


        Divider(
            color = TextGray,
            thickness = 2.dp,
            modifier = Modifier
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
        ConfirmationLazyScreen(
            helperViewModel = helperViewModel
        )
    }
}

@Composable
fun HelpElement(
    modifier: Modifier = Modifier,
    money: Int,
    userName: String,
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
            text = userName,
            fontSize = 12.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
//        Text(text = "+ $money$")
    }
}

@Composable
fun ConfirmationLazyScreen(
    helperViewModel: HelperViewModel,
    modifier: Modifier = Modifier
) {
    val helpers by helperViewModel.helpers.collectAsState()

    LazyColumn(
        modifier = Modifier.padding(20.dp)
    ) {
        items(helpers) { item ->
            HelpElement(
                userName = item.helperName,
                drawable = R.drawable.default_avatar,
                money = 20
            )
        }
    }
}