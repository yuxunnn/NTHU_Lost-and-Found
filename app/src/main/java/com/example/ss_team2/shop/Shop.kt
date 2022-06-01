package com.example.ss_team2.shop

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
        //ItemList()
    }
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
                .clickable() {}
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
    price: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 16.dp)
            .height(72.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 3.dp,    //shadow
        backgroundColor = Iris60
    ) {
        Row() {
            Column() {
                Image(
                    painter = painterResource(drawable),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = itemName
                )
            }
            Text(
                text = itemNote
            )
            Column() {
                Row() {
                    Icon(
                        imageVector = Icons.Default.AttachMoney,
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                    )
                    Text(
                        text = "520",
                        fontSize = 36.sp //may bug
                    )
                }
                Button(onClick = {}, colors = ButtonDefaults.textButtonColors(
                    backgroundColor = Color.Blue
                )) {
                    Text("購買")
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
                itemNote = stringResource(R.string.NTUflagNote)
            )
    }
}

data class ItemData(val itemName: Int,val itemNote: Int,val itemprice: Int)

private val itemDataList: List<ItemData> = listOf(
    ItemData(R.string.NTUflag, R.string.NTUflagNote,500)
    //R.string.NTHUflag to R.string.NTHUflagNote,
    //R.string.NCTUflag to R.string.NCTUflagNote,
    //R.string.NCCUflag to R.string.NCCUflagNote,
    //R.string.Poopoo to R.string.PoopooNote,
    //R.string.Eraser to R.string.EraserNote,
    //R.string.BNT to R.string.BNTNote,
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
                price = item.itemprice,
                drawable = R.drawable.blue_flag //why bug?????
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun ItemCardsPreview() {
    SSteam2Theme { ItemCards() }
}
