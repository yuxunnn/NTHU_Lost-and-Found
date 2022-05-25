package com.example.ss_team2.profile

import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ss_team2.ui.theme.SSteam2Theme

@Composable
fun UserPostCardList(
    tabPage: Int,
    modifier: Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 10.dp, horizontal = 20.dp),
        modifier = modifier
            .fillMaxWidth()
    ) {
        repeat(4){

            items(if (tabPage == 0) tempUserPostData else tempUserPostData2) { item ->
                UserPostCard(
                    type = item.type,
                    image = item.image,
                    what = item.what,
                    where = item.where,
                    modifier = Modifier
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "UserPostCardListPreviewDark",
    backgroundColor = 0xff000000
)
@Preview(showBackground = true, name = "UserPostCardListPreviewLight")
@Composable
fun UserPostCardListPreview(){
    SSteam2Theme {
        UserPostCardList(
            tabPage  = 0,
            modifier = Modifier
        )
    }
}