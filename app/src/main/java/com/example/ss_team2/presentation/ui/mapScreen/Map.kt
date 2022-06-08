package com.example.ss_team2.presentation.ui.mapScreen

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.ss_team2.R
import com.example.ss_team2.data.data_source.MapItem
import com.example.ss_team2.data.data_source.User
import com.example.ss_team2.data.data_source.UserItem
import com.example.ss_team2.presentation.viewModel.MapViewModel
import com.example.ss_team2.presentation.viewModel.UserViewModel
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun Map(
    userViewModel: UserViewModel,
    mapViewModel: MapViewModel,
    modifier: Modifier
) {

    val selectedItem: String by userViewModel.selectedItem.collectAsState()
    val user: User by userViewModel.user.collectAsState()
    val userItem: UserItem by userViewModel.userItem.collectAsState()
    val toolMarkers: List<MapItem> by mapViewModel.toolMarkers.collectAsState()
    val properties: MapProperties by mapViewModel.properties.collectAsState()
    val cameraPositionState: CameraPositionState by mapViewModel.cameraPositionState.collectAsState()

    GoogleMap(
        uiSettings = MapUiSettings(mapToolbarEnabled = false),
        properties = properties,
        cameraPositionState = cameraPositionState,
        modifier = modifier,
        onMapClick = {

            val selectedItemCount = when (selectedItem){
                "orangeFlag" -> userItem.orangeFlag
                "purpleFlag" -> userItem.purpleFlag
                "yellowFlag" -> userItem.yellowFlag
                "blueFlag" -> userItem.blueFlag
                "shit" -> userItem.shit
                else -> userItem.vaccine
            }

            val itemType = when (selectedItem) {
                "orangeFlag" -> 0
                "purpleFlag" -> 1
                "yellowFlag" -> 2
                "blueFlag" -> 3
                "shit" -> 4
                else -> 5
            }

            if (selectedItemCount > 0){
                mapViewModel.addMarker(
                    itemType = itemType,
                    latLng = it,
                    userName = user.userName,
                    userSchool = user.userSchool
                )
                userViewModel.updateUserItem(
                    userName = user.userName,
                    itemType = selectedItem,
                    changeNum = -1
                )
            }
        }
    ) {
        toolMarkers.forEach {
            val position = LatLng(it.latitude, it.longitude)
            val image = when(it.itemType){
                0 -> R.drawable.orange_flag_60
                1 -> R.drawable.purple_flag_60
                2 -> R.drawable.yellow_flag_60
                3 -> R.drawable.blue_flag_60
                4 -> R.drawable.poopoo_60
                else -> R.drawable.bnt_60
            }
            val icon = BitmapDescriptorFactory.fromResource(image)
            Marker(
                state = MarkerState(position = position),
                icon = icon,
                title = it.userName,
                snippet = it.userSchool,
            )
        }
    }

}
