package com.example.ss_team2.homepage

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ss_team2.ui.theme.SSteam2Theme


@Composable
fun SchoolFlag(
    school: Int,
    currentSchool: Int,
    onClick: () -> Unit
) {
    val color: Color = if (school != currentSchool) Color.LightGray
        else when (school) {
        1 -> Color.Magenta
        2 -> Color.Yellow
        3 -> Color.Cyan
        else -> Color.Blue
    }
    val text: String = when (school) {
        1 -> "清"
        2 -> "交"
        3 -> "台"
        else -> "政"
    }

    Button(
        onClick = onClick,
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        modifier = Modifier
            .width(60.dp)
            .height(80.dp)
            .clip(CutCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp))
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.offset(y = (-10).dp)
        )
    }
}

@Composable
fun LostFindButton(
    type: Int,
    onClick: () -> Unit
) {
    val color: Color = when (type) {
        1 -> Color.Red
        2 -> Color.Green
        else -> Color.Cyan
    }
    val text: String = when (type) {
        1 -> "遺失"
        2 -> "撿到"
        else -> "前往地圖"
    }

    Button(
        onClick = onClick,
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        modifier = Modifier
            .width(200.dp)
            .height(80.dp)
            .clip(CutCornerShape(size = 8.dp))
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun HomepageScreen(modifier: Modifier) {

    val currentSchool = remember { mutableStateOf(2) }

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .absoluteOffset(y = 60.dp)
            .padding(horizontal = 8.dp)
            .fillMaxWidth()
    ) {
        SchoolFlag(
            school = 1,
            currentSchool = currentSchool.value,
            onClick = { currentSchool.value = 1 }
        )
        SchoolFlag(
            school = 2,
            currentSchool = currentSchool.value,
            onClick = { currentSchool.value = 2 }
        )
        SchoolFlag(
            school = 3,
            currentSchool = currentSchool.value,
            onClick = { currentSchool.value = 3 }
        )
        SchoolFlag(
            school = 4,
            currentSchool = currentSchool.value,
            onClick = { currentSchool.value = 4 }
        )

    }
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .absoluteOffset(y = 160.dp)
            .height(360.dp)
            .fillMaxWidth()
    ) {
        LostFindButton(type = 1, onClick = {})
        LostFindButton(type = 2, onClick = {})
        LostFindButton(type = 3, onClick = {})
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun HomepagePreview() {
    SSteam2Theme {
        Scaffold { padding ->
            HomepageScreen(modifier = Modifier.padding(padding))
        }
    }
}
