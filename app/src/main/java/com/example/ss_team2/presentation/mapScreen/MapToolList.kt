package com.example.ss_team2.presentation.mapScreen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ss_team2.R

data class Tool (val image: Int, val amount: Int)

private val toolList: List<Tool> = listOf(
    Tool(image = R.drawable.nthu_flag, amount = 0),
    Tool(image = R.drawable.poop, amount = 998)
)

@Composable
fun MapToolList(

    modifier: Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .fillMaxWidth()
    ) {
        items(toolList) { tool ->
            MapTool(image = tool.image, amount = tool.amount)
        }
    }
}