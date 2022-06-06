package com.example.ss_team2.presentation.ui.shop

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ss_team2.R
import com.example.ss_team2.ui.theme.Iris60
import com.example.ss_team2.ui.theme.SSteam2Theme



@Composable
fun Shop(){
    Column() {
        Title(money = "520")
        Divider(startIndent = 0.dp, thickness = 3.dp, color = Color.Black)
        ItemCards()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun ShopPreview() {
    SSteam2Theme { Shop() }
}


@Composable
fun Title(
    modifier: Modifier = Modifier,
    money: String
){
    Row(
        Modifier.fillMaxWidth(),
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBackIos,
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .padding(start = 8.dp)
                .clickable() {

                }
        )
        Text(
            text = "購買道具",
            fontSize = 36.sp,
            modifier = Modifier.padding(start = 70.dp,end = 16.dp)
        )
        Row() {
            Icon(
                imageVector = Icons.Default.AttachMoney,
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
            )
            Text(
                text = money,
                fontSize = 36.sp //may bug
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun TitlePreview() {
    SSteam2Theme { Title(money = "520") }
}

@Composable
fun ItemCard(
    @DrawableRes drawable: Int,
    itemName: String,
    itemNote: String,
    itemPrice: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 16.dp)
            .height(84.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 3.dp,    //shadow
        backgroundColor = Color.White
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Column() {
                Spacer(modifier = Modifier.height(12.dp))
                Image(
                    painter = painterResource(drawable),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                )
                Text(
                    text = itemName
                )
            }
            Text(
                text = itemNote,
                modifier = Modifier.padding(top = 30.dp)
            )

            Column() {
                Row() {
                    Icon(
                        imageVector = Icons.Default.AttachMoney,
                        contentDescription = null,
                        modifier = Modifier
                            .size(32.dp)
                    )
                    Text(
                        text = itemPrice.toString(),
                        fontSize = 25.sp //may bug
                    )
                }
                Button(
                    onClick = {}, colors = ButtonDefaults.textButtonColors(
                        backgroundColor = Iris60
                    ),
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text(
                        text = "購買",
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun ItemCardPreview() {
    SSteam2Theme {
            ItemCard(
                drawable = R.drawable.blue_flag,
                modifier = Modifier.padding(8.dp),
                itemName = stringResource(R.string.NTUflag),
                itemNote = stringResource(R.string.NTUflagNote),
                itemPrice = 500
            )
    }
}

data class ItemData(
    val itemName: Int,
    val itemNote: Int,
    val itemprice: Int,
    @DrawableRes val itemDrawable: Int
    )

private val itemDataList: List<ItemData> = listOf(
    ItemData(R.string.NTUflag, R.string.NTUflagNote,500, R.drawable.orange_flag),
    ItemData(R.string.NTHUflag, R.string.NTHUflagNote,500, R.drawable.purple_flag),
    ItemData(R.string.NCTUflag, R.string.NCTUflagNote,500, R.drawable.yellow_flag),
    ItemData(R.string.NCCUflag, R.string.NCCUflagNote,500, R.drawable.blue_flag),
    ItemData(R.string.Poopoo, R.string.PoopooNote,500,R.drawable.poopoo),
    ItemData(R.string.Eraser, R.string.EraserNote,500,R.drawable.eraser),
    ItemData(R.string.BNT, R.string.BNTNote,500,R.drawable.bnt)
)

@Composable
fun ItemCards() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(itemDataList) { item ->
            ItemCard(
                itemName= stringResource(item.itemName),
                itemNote = stringResource(item.itemNote),
                itemPrice = item.itemprice,
                drawable = item.itemDrawable
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun ItemCardsPreview() {
    SSteam2Theme { ItemCards() }
}
