package com.example.ss_team2.presentation.ui.whereYouLost

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.ui.whatYouLost.locationLabels1
import com.example.ss_team2.presentation.ui.whatYouLost.locationLabels2
import com.example.ss_team2.ui.theme.Iris60
import com.example.ss_team2.ui.theme.SSteam2Theme
import com.example.ss_team2.ui.theme.TextGray

@Composable
fun WhereYouLost(
    navController: NavController,
    what: String
){
    Column() {
        Lastpage(navController)
        Spacer(modifier = Modifier.height(40.dp))
        SearchBar()
        Spacer(modifier = Modifier.height(40.dp))
        LocationLabels()
        Spacer(modifier = Modifier.height(160.dp))
        NextButton(navController = navController, what = what)
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
            text = "遺失地點",
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

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun SearchBarPreview() {
    SSteam2Theme { SearchBar(Modifier.padding(8.dp)) }
}

@Composable
fun LocationLabelsElement(
    modifier: Modifier = Modifier,
    text: String
){
    Card(
        modifier = Modifier.padding(8.dp).clickable {  },
        shape = MaterialTheme.shapes.small,
        elevation = 3.dp    //shadow
    ){
        Box(
            modifier = Modifier
                .padding(8.dp)
                .width(40.dp),
            contentAlignment = Alignment.Center,
        ){
            Text(
                text =  text,
                fontSize = 12.sp,
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun LocationLabelsElementPreview() {
    SSteam2Theme { LocationLabelsElement(Modifier.padding(8.dp), "台達館") }
}




@Composable
fun LocationLabels(
    modifier: Modifier = Modifier
){
    Column() {
        LazyRow(
            horizontalArrangement = Arrangement.SpaceBetween,
            contentPadding = PaddingValues(horizontal = 1.dp),
            modifier = modifier.fillMaxWidth()
        ) {
            items(locationLabels1) { item ->
                LocationLabelsElement(Modifier, item)
            }
        }
        LazyRow(
            horizontalArrangement = Arrangement.SpaceBetween,
            contentPadding = PaddingValues(horizontal = 1.dp),
            modifier = modifier.fillMaxWidth()
        ) {
            items(locationLabels2) { item ->
                LocationLabelsElement(Modifier, item)
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun LocationLabelsPreview() {
    SSteam2Theme { LocationLabels()}
}

@Composable
fun NextButton(
    navController: NavController,
    what: String
){
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                    navController.navigate(route = Screen.LostList.passWhatAndWhere(
                        what = what,
                        where = "qq"
                    ))
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

