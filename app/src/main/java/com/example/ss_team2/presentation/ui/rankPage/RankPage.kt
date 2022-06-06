package com.example.ss_team2.presentation.ui.rankPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ss_team2.R

import com.example.ss_team2.presentation.ui.homepage.HomepageScreen
import com.example.ss_team2.presentation.ui.utility.BottomBar
import com.example.ss_team2.ui.theme.SSteam2Theme

@Composable
fun RankPage() {
    Column() {
        Title()
        Divider(startIndent = 0.dp, thickness = 3.dp, color = Color.Black)
        TopButtons()

        //Need to be modified
        Podium(No_1 = "清華大學", No_2 = "台灣大學", No_3 = "交通大學", No_1_Score = 2000, No_2_Score = 1500, No_3_Score = 1000)
        TrashCan(No_4 = "政治大學", No_4_Score = 500)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun RankPagePreview(){
    SSteam2Theme() {
        RankPage()
    }
}

@Composable
fun Title(){
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        Text(
            text = "積分榜",
            fontSize = 36.sp
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun TitlePreview(){
    SSteam2Theme() {
        Title()
    }
}

@Composable
fun TopButtons(){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ){
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .height(50.dp)
                .width(80.dp)
        ) {
            Text(
                text = "本週",
                fontSize = 20.sp
            )
        }

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .height(50.dp)
                .width(80.dp)
        ) {
            Text(
                text = "累積",
                fontSize = 20.sp
            )
        }

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .height(50.dp)
                .width(80.dp)
        ) {
            Text(
                text = "本月",
                fontSize = 20.sp
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun TopButtonsPreview(){
    SSteam2Theme() {
        TopButtons()
    }
}

@Composable
fun Podium(
    No_1: String,
    No_2: String,
    No_3: String,

    No_1_Score: Int,
    No_2_Score: Int,
    No_3_Score: Int,

){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.podium),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(200.dp)
                    .size(500.dp)
            )

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(18.dp, Alignment.CenterHorizontally)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = No_3,
                        fontSize = 16.sp
                    )
                    Text(
                        text = No_3_Score.toString()
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = No_1,
                        fontSize = 16.sp,
                        color = Color.Yellow
                    )
                    Text(
                        text = No_1_Score.toString(),
                        color = Color.Yellow
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = No_2,
                        fontSize = 16.sp
                    )
                    Text(
                        text = No_2_Score.toString()
                    )
                }
            }

        }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun PodiumPreview(){
    SSteam2Theme() {
        Podium(
            "清華大學",
            "台灣大學",
            "交通大學",
            2000,
            1500,
            1000,
        )
    }
}

@Composable
fun TrashCan(
    No_4:String,
    No_4_Score:Int,
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.trashcan),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(130.dp)
        )

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = No_4,
                    fontSize = 12.sp
                )
                Text(
                    text = No_4_Score.toString()
                )
            }

        }

    }
}

@Composable
fun Rank(
    navController: NavController
) {
    SSteam2Theme {
        Scaffold(
            bottomBar = { BottomBar(modifier = Modifier, navController) }
        ) {
            RankPage()
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun TrashCanPreview() {
    SSteam2Theme() {
        TrashCan(
            No_4 = "政治大學",
            No_4_Score = 500
        )
    }
}