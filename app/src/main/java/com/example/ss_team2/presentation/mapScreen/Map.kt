package com.example.ss_team2.presentation.mapScreen

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.ss_team2.R
import com.example.ss_team2.domain.model.ToolMarker
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun Map(
    viewModel: MapViewModel,
    modifier: Modifier
) {

    val toolMarkers: List<ToolMarker> by viewModel.toolMarkers.collectAsState()
    val properties: MapProperties by viewModel.properties.collectAsState()
    val cameraPositionState: CameraPositionState by viewModel.cameraPositionState.collectAsState()

    GoogleMap(
        uiSettings = MapUiSettings(mapToolbarEnabled = false),
        properties = properties,
        cameraPositionState = cameraPositionState,
        modifier = modifier,
        onMapClick = {
            viewModel.addMarker(it, R.drawable.poopoo)
        }
    ) {
        toolMarkers.forEach {
            val position = LatLng(it.latitude, it.longitude)
            val icon = BitmapDescriptorFactory.fromResource(it.image)
            Marker(
                state = MarkerState(position = position),
//                icon = icon,
                title = "frog_0219",
                snippet = "國立台灣大學",
            )
        }
    }

}
