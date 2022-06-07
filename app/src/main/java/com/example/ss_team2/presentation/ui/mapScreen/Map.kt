package com.example.ss_team2.presentation.ui.mapScreen

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.ss_team2.R
import com.example.ss_team2.data.data_source.MapItem
import com.example.ss_team2.presentation.viewModel.MapViewModel
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun Map(
    viewModel: MapViewModel,
    modifier: Modifier
) {

    val toolMarkers: List<MapItem> by viewModel.toolMarkers.collectAsState()
    val properties: MapProperties by viewModel.properties.collectAsState()
    val cameraPositionState: CameraPositionState by viewModel.cameraPositionState.collectAsState()

    GoogleMap(
        uiSettings = MapUiSettings(mapToolbarEnabled = false),
        properties = properties,
        cameraPositionState = cameraPositionState,
        modifier = modifier,
        onMapClick = {
            viewModel.addMarker(
                itemType = R.drawable.poop_60,
                latLng = it,
                userName = "teste",
                userSchool = "hello"
            )
        }
    ) {
        toolMarkers.forEach {
            val position = LatLng(it.latitude, it.longitude)
            val icon = BitmapDescriptorFactory.fromResource(R.drawable.poop_60)
            Marker(
                state = MarkerState(position = position),
                icon = icon,
                title = it.userName,
                snippet = it.userSchool,
            )
        }
    }

}
