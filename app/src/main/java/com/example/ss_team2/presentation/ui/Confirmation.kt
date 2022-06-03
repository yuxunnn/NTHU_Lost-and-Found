package com.example.ss_team2



import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ss_team2.presentation.ui.DrawableStringPair
import com.example.ss_team2.presentation.ui.ItemCard
import com.example.ss_team2.ui.theme.SSteam2Theme

@Composable
fun ConfirmationHomeScreen(
    modifier: Modifier = Modifier,
    @DrawableRes itemdrawable: Int,
    @StringRes description: Int,
    @StringRes what: Int,
    @StringRes where: Int,
    money: Int
) {
    Column(
        modifier = Modifier
    ) {
        Text(text = stringResource(id = R.string.Confirm),
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
        ItemCard(drawable = itemdrawable, description = description, what = what, where = where)
        Row(
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "請選擇積分給予有協助的對象",
                modifier = Modifier.padding(8.dp)
            )
            Spacer(modifier = Modifier.width(108.dp))
            Text(text = " $money$", modifier = Modifier.padding(8.dp))
        }
        ConfirmationLazyScreen()
    }
}


@Composable
fun ConfirmationFinalScreen(modifier: Modifier = Modifier,
                            @DrawableRes itemdrawable: Int,
                            @StringRes description: Int,
                            @StringRes what: Int,
                            @StringRes where: Int, 
                            money: Int
){
    Box(modifier = Modifier.fillMaxSize()){
        ConfirmationHomeScreen(
            itemdrawable = itemdrawable, description = description, what = what, where = where, money = money)
        Icon(
            Icons.Filled.ArrowBack,
            "",
            modifier = Modifier
                .align(Alignment.TopStart)
                .clickable {}
                .padding(16.dp)
        )
        Button(
            onClick = {},
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
){
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
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
        Text(text = "+ $money$", )
    }
}

@Composable
fun ConfirmationLazyScreen(
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier = Modifier.padding(20.dp)
    ) {
        items(TestData){
                item -> HelpElement(username = item.text, drawable = item.drawable, money = 20)
        }
    }
}

private val TestData = listOf(
    R.drawable.ic_launcher_background to R.string.ball,
    R.drawable.ic_launcher_background to R.string.ball,
).map { DrawableStringPair(it.first, it.second) }




@Preview(showBackground = true)
@Composable
fun DefaultPreview7() {
    SSteam2Theme {
        ConfirmationFinalScreen(
            itemdrawable = R.drawable.ic_launcher_foreground,
            description = R.string.description,
            what = R.string.ball,
            where = R.string.home,
            money = 20
        )
    }
}