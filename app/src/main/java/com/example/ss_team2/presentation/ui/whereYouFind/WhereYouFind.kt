package com.example.ss_team2.presentation.ui.whereYouFind

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.navigation.Screen.FindList.passWhatAndWhere
import com.example.ss_team2.presentation.ui.whatYouLost.locationLabels1
import com.example.ss_team2.presentation.ui.whatYouLost.locationLabels2
import com.example.ss_team2.presentation.viewModel.PostViewModel
import com.example.ss_team2.ui.theme.Iris60
import com.example.ss_team2.ui.theme.SSteam2Theme
import com.example.ss_team2.ui.theme.TextGray

@Composable
fun WhereYouFind(
    navController: NavController,
    what: String,
    modifier: Modifier = Modifier,
    postViewModel: PostViewModel = viewModel()
){
    val isClicked1 = remember { mutableStateOf(false) }
    val isClicked2 = remember { mutableStateOf(false) }
    val isClicked3 = remember { mutableStateOf(false) }
    val isClicked4 = remember { mutableStateOf(false) }
    val isClicked5 = remember { mutableStateOf(false) }
    val isClicked6 = remember { mutableStateOf(false) }
    val isClicked7 = remember { mutableStateOf(false) }
    val isClicked8 = remember { mutableStateOf(false) }

    val chosen = remember { mutableStateOf("") }

    Column() {
        Lastpage(navController)
        Spacer(modifier = Modifier.height(40.dp))
        SearchBar()
        Spacer(modifier = Modifier.height(40.dp))

        Column() {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.fillMaxWidth()
            ) {
                Button(
                    modifier = Modifier.padding(8.dp),
                    shape = MaterialTheme.shapes.small,
                    onClick = {
                        isClicked1.value = !isClicked1.value
                        chosen.value = "台達館"
                    },
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = if(isClicked1.value) Color.Gray else Color.White
                    )
                ){
                    Text(
                        text =  "台達館",
                        fontSize = 12.sp,
                    )
                }

                Button(
                    modifier = Modifier.padding(8.dp),
                    shape = MaterialTheme.shapes.small,
                    onClick = {
                        isClicked2.value = !isClicked2.value
                        chosen.value = "資電館"
                    },
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = if(isClicked2.value) Color.Gray else Color.White
                    )
                ){
                    Text(
                        text =  "資電館",
                        fontSize = 12.sp,
                    )
                }

                Button(
                    modifier = Modifier.padding(8.dp),
                    shape = MaterialTheme.shapes.small,
                    onClick = {
                        isClicked3.value = !isClicked3.value
                        chosen.value = "風雲樓"
                    },
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = if(isClicked3.value) Color.Gray else Color.White
                    )
                ){
                    Text(
                        text =  "風雲樓",
                        fontSize = 12.sp,
                    )
                }

                Button(
                    modifier = Modifier.padding(8.dp),
                    shape = MaterialTheme.shapes.small,
                    onClick = {
                        isClicked4.value = !isClicked4.value
                        chosen.value = "小吃部"
                    },
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = if(isClicked4.value) Color.Gray else Color.White
                    )
                ){
                    Text(
                        text =  "小吃部",
                        fontSize = 12.sp,
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.fillMaxWidth()
            ) {
                Button(
                    modifier = Modifier.padding(8.dp),
                    shape = MaterialTheme.shapes.small,
                    onClick = {
                        isClicked5.value = !isClicked5.value
                        chosen.value = "碩齋"
                    },
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = if(isClicked5.value) Color.Gray else Color.White
                    )
                ){
                    Text(
                        text =  "碩齋",
                        fontSize = 12.sp,
                    )
                }

                Button(
                    modifier = Modifier.padding(8.dp),
                    shape = MaterialTheme.shapes.small,
                    onClick = {
                        isClicked6.value = !isClicked6.value
                        chosen.value = "教育館"
                    },
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = if(isClicked6.value) Color.Gray else Color.White
                    )
                ){
                    Text(
                        text =  "教育館",
                        fontSize = 12.sp,
                    )
                }

                Button(
                    modifier = Modifier.padding(8.dp),
                    shape = MaterialTheme.shapes.small,
                    onClick = {
                        isClicked7.value = !isClicked7.value
                        chosen.value = "圖書館"
                    },
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = if(isClicked7.value) Color.Gray else Color.White
                    )
                ){
                    Text(
                        text =  "圖書館",
                        fontSize = 12.sp,
                    )
                }

                Button(
                    modifier = Modifier.padding(8.dp),
                    shape = MaterialTheme.shapes.small,
                    onClick = {
                        isClicked8.value = !isClicked8.value
                        chosen.value = "人社院"
                    },
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = if(isClicked8.value) Color.Gray else Color.White
                    )
                ){
                    Text(
                        text =  "人社院",
                        fontSize = 12.sp,
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(160.dp))

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    navController.navigate(route = Screen.FindList.passWhatAndWhere(
                        what = what,
                        where = chosen.value
                    ))
                    postViewModel.postSearch("find",what,chosen.value)
                },
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = Iris60
                ),
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    text = "完成",
                    color = Color.White
                )
            }
        }
    }
}


@Composable
fun Lastpage(
    navController: NavController
){
    //var enabled = true  //test
    Icon(
        imageVector = Icons.Default.ArrowBackIos,
        contentDescription = null,
        tint = TextGray,
        modifier = Modifier
            .size(48.dp)
            .padding(start = 8.dp)
            .clickable() {
                navController.popBackStack()
            }
    )
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    // Implement composable here
    Column(
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "撿到地點",
            modifier = Modifier
                .paddingFromBaseline(bottom = 8.dp)
                .padding(start = 8.dp),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = TextGray
        )
        TextField(
            value = "",
            onValueChange = {},
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
                .fillMaxWidth()
                .heightIn(min = 56.dp)
                .padding(start = 8.dp,end = 8.dp)
        )
    }
}
//
//@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
//@Composable
//fun SearchBarPreview() {
//    SSteam2Theme { SearchBar(Modifier.padding(8.dp)) }
//}
//
//@Composable
//fun LocationLabelsElement(
//    modifier: Modifier = Modifier,
//    text: String
//){
//    Card(
//        modifier = Modifier.padding(8.dp).clickable {  },
//        shape = MaterialTheme.shapes.small,
//        elevation = 3.dp    //shadow
//    ){
//        Box(
//            modifier = Modifier
//                .padding(8.dp)
//                .width(40.dp),
//            contentAlignment = Alignment.Center,
//        ){
//            Text(
//                text =  text,
//                fontSize = 12.sp,
//            )
//        }
//    }
//}
//
//@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
//@Composable
//fun LocationLabelsElementPreview() {
//    SSteam2Theme { LocationLabelsElement(Modifier.padding(8.dp), "台達館") }
//}
//
//
//
//
//@Composable
//fun LocationLabels(
//    modifier: Modifier = Modifier
//){
//    Column() {
//        LazyRow(
//            horizontalArrangement = Arrangement.SpaceBetween,
//            contentPadding = PaddingValues(horizontal = 1.dp),
//            modifier = modifier.fillMaxWidth()
//        ) {
//            items(locationLabels1) { item ->
//                LocationLabelsElement(Modifier, item)
//            }
//        }
//        LazyRow(
//            horizontalArrangement = Arrangement.SpaceBetween,
//            contentPadding = PaddingValues(horizontal = 1.dp),
//            modifier = modifier.fillMaxWidth()
//        ) {
//            items(locationLabels2) { item ->
//                LocationLabelsElement(Modifier, item)
//            }
//        }
//    }
//}
//
//@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
//@Composable
//fun LocationLabelsPreview() {
//    SSteam2Theme { LocationLabels()}
//}
//
//@Composable
//fun NextButton(
//    navController: NavController,
//    what: String
//){
//    Row(
//        Modifier.fillMaxWidth(),
//        horizontalArrangement = Arrangement.Center
//    ) {
//        Button(
//            onClick = {
//                      navController.navigate(route = Screen.FindList.passWhatAndWhere(
//                          what = what,
//                          where = "chosen"
//                      ))
//            },
//            colors = ButtonDefaults.textButtonColors(
//                backgroundColor = Iris60
//            ),
//            modifier = Modifier.padding(start = 8.dp)
//        ) {
//            Text(
//                text = "完成",
//                color = Color.White
//            )
//        }
//    }
//}
