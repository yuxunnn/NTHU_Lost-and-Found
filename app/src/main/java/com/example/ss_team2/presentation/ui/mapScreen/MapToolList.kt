package com.example.ss_team2.presentation.ui.mapScreen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ss_team2.R
import com.example.ss_team2.presentation.viewModel.MapViewModel
import com.example.ss_team2.presentation.viewModel.UserViewModel

@Composable
fun MapToolList(
    userViewModel: UserViewModel,
    modifier: Modifier
) {

    val userItems by userViewModel.userItem.collectAsState()
    val selectedItem by userViewModel.selectedItem.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .fillMaxSize()
    ) {
        item {
            MapTool(
                image = R.drawable.orange_flag,
                amount = userItems.orangeFlag,
                selected = selectedItem == "orangeFlag",
                onClick = { userViewModel.changeSelectedItem("orangeFlag") }
            )
        }
        item {
            MapTool(
                image = R.drawable.purple_flag,
                amount = userItems.purpleFlag,
                selected = selectedItem == "purpleFlag",
                onClick = { userViewModel.changeSelectedItem("purpleFlag") }
            )
        }
        item {
            MapTool(
                image = R.drawable.yellow_flag,
                amount = userItems.yellowFlag,
                selected = selectedItem == "yellowFlag",
                onClick = { userViewModel.changeSelectedItem("yellowFlag") }
            )
        }
        item {
            MapTool(
                image = R.drawable.blue_flag,
                amount = userItems.blueFlag,
                selected = selectedItem == "blueFlag",
                onClick = { userViewModel.changeSelectedItem("blueFlag") }
            )
        }
        item {
            MapTool(
                image = R.drawable.poopoo,
                amount = userItems.shit,
                selected = selectedItem == "shit",
                onClick = { userViewModel.changeSelectedItem("shit") }
            )
        }
        item {
            MapTool(
                image = R.drawable.bnt,
                amount = userItems.vaccine,
                selected = selectedItem == "vaccine",
                onClick = { userViewModel.changeSelectedItem("vaccine") }
            )
        }
    }
}