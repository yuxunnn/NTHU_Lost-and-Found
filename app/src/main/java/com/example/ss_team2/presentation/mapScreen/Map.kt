package com.example.ss_team2.presentation.mapScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.maps.android.compose.*

data class Tool(val image: Int, val latitude: Double, val longitude: Double)

private val schoolBoundList: List<LatLngBounds> = listOf(
    LatLngBounds(
        LatLng(24.785873962215856, 120.98821252942336),
        LatLng(24.79756836250363, 120.99683182522938)
    ),
    LatLngBounds(
        LatLng(24.783191960339387, 120.9927487833885),
        LatLng(24.7911763627771, 121.00262095071143)
    ),
    LatLngBounds(
        LatLng(25.011043330289002, 121.52723126971628),
        LatLng(25.02396149088832, 121.54718917224235)
    ),
    LatLngBounds(
        LatLng(24.977294609857477, 121.56744500625103),
        LatLng(24.990246332728795, 121.58087918794664)
    )
)

@Composable
fun Map(
    cameraPositionState: CameraPositionState,
    currentSchool: Int,
    tools: List<Tool>,
    modifier: Modifier
) {
    GoogleMap(
        properties = MapProperties(
            latLngBoundsForCameraTarget = schoolBoundList[currentSchool],
            minZoomPreference = 15f
        ),
        cameraPositionState = cameraPositionState,
        modifier = modifier
    ){
        tools.forEach {
            val toolPosition = LatLng(it.latitude, it.longitude)
            Marker(state = MarkerState(position = toolPosition))
        }
    }
}
