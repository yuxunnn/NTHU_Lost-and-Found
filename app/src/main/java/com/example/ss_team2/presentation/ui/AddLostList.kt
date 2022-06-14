package com.example.ss_team2.presentation.ui


import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.apollographql.apollo3.api.Optional
import com.example.ss_team2.R
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.viewModel.PostViewModel
import com.example.ss_team2.presentation.viewModel.UserViewModel
import com.example.ss_team2.type.PostCreateInput


@Composable
fun AddLostList(
    navController: NavController,
    what: String,
    where: String,
    postViewModel: PostViewModel,
    userViewModel: UserViewModel

){
    val first = remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null)}
    val context = LocalContext.current
    val bitmap = remember {
        mutableStateOf<Bitmap?>(null)
    }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ){
            uri: Uri? ->
        imageUri = uri
    }
    val user by userViewModel.user.collectAsState()
    var postDescription by remember { mutableStateOf("") }
    val checkedState = remember { mutableStateOf(false) }
    var reward by remember { mutableStateOf("") }

    val icon = Icons.Default.AttachMoney

    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier
        ) {
            Text(text = stringResource(id = R.string.AddLostList),
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

            //AnonymousUserCard(str = R.string.Loser, drawable = R.drawable.ic_launcher_foreground)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(60.dp)
                        .padding(8.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = user.userName,
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

                Switch(
                    checked = checkedState.value,
                    onCheckedChange = { checkedState.value = it },
                    colors = SwitchDefaults.colors(checkedThumbColor = Color.DarkGray,
                        uncheckedThumbColor = Color.DarkGray,
                        checkedTrackColor = Color.Blue,
                        uncheckedTrackColor = Color.Blue,)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .background(Color(220, 220, 220)),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.spacedBy(36.dp)
            ) {
                //Image
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    imageUri?.let {
                        if(Build.VERSION.SDK_INT <28 ){
                            bitmap.value = MediaStore.Images
                                .Media.getBitmap(context.contentResolver, it)
                            //Log.d("Args" ,"1")
                        }else {
                            val source = ImageDecoder.createSource(context.contentResolver, it)
                            bitmap.value = ImageDecoder.decodeBitmap(source)
                            //Log.d("Args" ,source.toString())
                        }
                    }
                    val icon = BitmapFactory.decodeResource(context.getResources(),
                        R.drawable.defaultpicture)
                    if(first.value) bitmap.value = bitmap.value else bitmap.value = icon
                    bitmap.value?.let { btm ->
                        Image(
                            bitmap = btm.asImageBitmap(),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(4.dp)
                                .clip(CircleShape)
                                .width(120.dp)
                                .height(120.dp)
                                .clickable {
                                    first.value = true
                                    launcher.launch("image/*")
                                }
                        )
                    }
                }

                Column(modifier = Modifier) {
                    Column(
                        modifier = Modifier,
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
                            modifier = Modifier,
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
                            modifier = Modifier,
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

                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = postDescription,
                        onValueChange = { postDescription = it },
                        label = { Text(text = "物品描述") },
                        modifier = Modifier
                            .width(180.dp)
                            .height(160.dp)
                    )
                }
            }


            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()) {
                TextField(
                    value = reward,
                    onValueChange = { reward = it },
                    label = { Text(text = "報酬") },
                    modifier = Modifier.width(300.dp),
                    leadingIcon = {
                        Icon(icon, "contentDescription")
                    }
                )
            }


            //先不做
//            Spacer(modifier = Modifier.height(16.dp))
//            Text(text = "誰可以看到這篇貼文")
//            Spacer(modifier = Modifier.height(16.dp))
//            Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically
//            ) {
//                val checkedState = remember { mutableStateOf(false) }              //State!!!
//                Checkbox(
//                    checked = checkedState.value,
//                    onCheckedChange = { checkedState.value = it }
//                )
//                Text(text = "男生")
//            }
//            Row(modifier = Modifier,verticalAlignment = Alignment.CenterVertically) {
//                val checkedState = remember { mutableStateOf(false) }              //State!!!
//                Checkbox(
//                    checked = checkedState.value,
//                    onCheckedChange = { checkedState.value = it }
//                )
//                Text(text = "女生")
//            }
        }


        Icon(
            Icons.Filled.Close,
            "",
            modifier = Modifier
                .align(Alignment.TopStart)
                .clickable {
                    navController.popBackStack()
                }
                .padding(16.dp)
        )
        Button(
            onClick = {
                postViewModel.createPost(
                    PostCreateInput(
                        author = user.userName,
                        postType = "lost",
                        itemType = what,
                        location = where,
                        itemImage = Optional.Present(imageUri.toString()),
                        postDescribe = Optional.Present(postDescription),
                        hasDone = false,
                        rewardCoin = reward.toInt(),
                        anonymous = false
                    )
                )
                userViewModel.updateUserQuest(user.userName,"quest2",1)
                navController.navigate(
                    route = Screen.LostList.passWhatAndWhere(
                        what = what,
                        where = where
                    )){
                    popUpTo(Screen.LostList.route){
                        inclusive = true
                    }
                }
            },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)
        ) {
            Text(text = "發布")
        }
    }
}

//@Preview
//@Composable
//fun AddLostListPreview (){
//    SSteam2Theme() {
//        AddLostList(what ="8787",where = "4565")
//    }
//}

//@Composable
//fun AddLostListHomeScreen(
//    modifier: Modifier = Modifier,
//    @DrawableRes userdrawable: Int,
//    @StringRes username: Int,
//    what: String,
//    where: String
//) {
//    var postDiscription by remember { mutableStateOf("") }
//
//    Column(
//        modifier = Modifier
//    ) {
//        Text(text = stringResource(id = R.string.AddLostList),
//            fontWeight = FontWeight.Bold,
//            color = Color(0x66,0x70,0x80),
//            modifier = Modifier
//                .paddingFromBaseline(top = 16.dp)
//                .fillMaxWidth(),
//            textAlign = TextAlign.Center,
//            fontSize = 32.sp
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        Divider(color = Color(0x66,0x70,0x80), thickness = 1.dp)
//        Spacer(modifier = Modifier.height(16.dp))
//        AnonymousUserCard(str = username, drawable = userdrawable)
//        EditItemCard(what = what, where = where)
//        Spacer(modifier = Modifier.height(16.dp))
//        TextField(
//            value = postDiscription,
//            onValueChange = { postDiscription = it },
//            label = { Text(text = "報酬") },
//            modifier = Modifier.padding(start = 40.dp)
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        Text(text = "誰可以看到這篇貼文")
//        Spacer(modifier = Modifier.height(16.dp))
//        Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically
//        ) {
//            val checkedState = remember { mutableStateOf(false) }              //State!!!
//            Checkbox(
//                checked = checkedState.value,
//                onCheckedChange = { checkedState.value = it }
//            )
//            Text(text = "男生")
//        }
//        Row(modifier = Modifier,verticalAlignment = Alignment.CenterVertically) {
//            val checkedState = remember { mutableStateOf(false) }              //State!!!
//            Checkbox(
//                checked = checkedState.value,
//                onCheckedChange = { checkedState.value = it }
//            )
//            Text(text = "女生")
//        }
//    }
//}


//@Composable
//fun AddLostListFinalScreen(modifier: Modifier = Modifier,
//                           @DrawableRes userdrawable: Int,
//                           @StringRes username: Int,
//                           navController: NavController,
//                           what: String,
//                           where: String,
//                           postViewModel: PostViewModel = viewModel(),
//                           userViewModel: UserViewModel = viewModel()
//){
//    val user by userViewModel.user.collectAsState()
//
//    Box(modifier = Modifier.fillMaxSize()){
//        AddLostListHomeScreen(
//            username = username, userdrawable = userdrawable, what = what,
//            where = where
//        )
//        Icon(
//            Icons.Filled.Close,
//            "",
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .clickable {
//                    navController.popBackStack()
//                }
//                .padding(16.dp)
//        )
//        Button(
//            onClick = {
//                postViewModel.createPost(PostCreateInput(
//                    author = user.userName,
//                    postType = "lost",
//                    itemType = what,
//                    location = where,
//                    //itemImage = ,
//                    postDescribe = ,
//                    hasDone = false,
//                    rewardCoin = 0,
//                    anonymous = false
//                )
//                )
//                navController.navigate(route = Screen.LostList.route){
//                    popUpTo(Screen.LostList.route){
//                        inclusive = true
//                    }
//                }
//            },
//            modifier = Modifier
//                .align(Alignment.TopEnd)
//                .padding(8.dp)
//        ) {
//            Text(text = "發布")
//        }
//    }
//}

