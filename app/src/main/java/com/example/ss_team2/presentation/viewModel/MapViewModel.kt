package com.example.ss_team2.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ss_team2.data.data_source.MapItem
import com.example.ss_team2.domain.use_case.MapUseCase
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.MapProperties
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

private val schoolPositionList: List<LatLng> = listOf(
    LatLng(24.796216802267217, 120.99668480810016),
    LatLng(24.786945096427186, 120.99749859318587),
    LatLng(25.017473169825568, 121.5397521708148),
    LatLng(24.988096573881222, 121.57738748320742)
)
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

const val InitialZoom = 15f

class MapViewModel : ViewModel() {

    private val mapUseCase = MapUseCase()

    private val _school = MutableStateFlow(0)
    private val _properties = MutableStateFlow(MapProperties())
    private val _cameraPositionState = MutableStateFlow(CameraPositionState())
    private val _toolMarkers = MutableStateFlow(listOf<MapItem>())

    val school: StateFlow<Int> = _school
    val properties: StateFlow<MapProperties> = _properties
    val toolMarkers: StateFlow<List<MapItem>> = _toolMarkers
    val cameraPositionState: StateFlow<CameraPositionState> = _cameraPositionState

    init {
        viewModelScope.launch {
            _school.value = 0
            _properties.value = MapProperties(minZoomPreference = InitialZoom)
            _cameraPositionState.value = CameraPositionState(
                position = CameraPosition.fromLatLngZoom(
                    schoolPositionList[0],
                    InitialZoom
                ),
            )
            _toolMarkers.value = mapUseCase.getMarkers()
        }
    }


    fun changeSchool(newSchool: Int) {
        viewModelScope.launch {
            _school.value = newSchool
            _cameraPositionState.value.animate(
                update = CameraUpdateFactory.newLatLngZoom(
                    schoolPositionList[newSchool],
                    InitialZoom
                )
            )
            _properties.value = properties.value.copy(
                latLngBoundsForCameraTarget = schoolBoundList[newSchool]
            )
        }
    }

    fun addMarker(itemType: Int, latLng: LatLng, userName: String, userSchool: String) {
        viewModelScope.launch {
            _toolMarkers.value = mapUseCase.addMarker(
                MapItem(
                    itemType = itemType,
                    latitude = latLng.latitude,
                    longitude = latLng.longitude,
                    userName = userName,
                    userSchool = userSchool
                )
            )
//            val new = _toolMarkers.value.toMutableList()
//            new.add(
//                MapItem(
//                    itemType = itemType,
//                    latitude = latLng.latitude,
//                    longitude = latLng.longitude,
//                    userName = userName,
//                    userSchool = userSchool
//                )
//            )
//            _toolMarkers.value = new
        }
    }
}