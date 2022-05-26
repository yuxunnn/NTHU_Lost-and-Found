package com.example.ss_team2.mapScreen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ss_team2.R

private val toolList: List<Int> = listOf(R.drawable.my_image, R.drawable.your_image, R.drawable.my_image)

@Composable
fun ToolList(modifier: Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp).fillMaxWidth()
    ){
        repeat(5){

            items(toolList) {
                image -> ToolButton(image = image)
            }
        }
    }
}