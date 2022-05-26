package com.example.ss_team2.mapScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

data class Tool(val image: Int, val latitude: Double, val longitude: Double)

@Composable
fun Map(
    cameraPositionState: CameraPositionState,
    tools: List<Tool>,
    modifier: Modifier
) {
    GoogleMap(
        modifier = modifier,
        cameraPositionState = cameraPositionState
    ){
        tools.forEach {
            val toolPosition = LatLng(it.latitude, it.longitude)
            Marker(state = MarkerState(position = toolPosition))
        }
    }
}
