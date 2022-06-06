package com.example.ss_team2.domain.use_case

import com.example.ss_team2.data.data_source.MapItem
import com.example.ss_team2.data.repository.MapItemRepository
import com.example.ss_team2.type.MapItemCreateInput

class MapUseCase {
    private val mapItemRepository =  MapItemRepository()

    suspend fun getMarkers(): MutableList<MapItem>{
        return mapItemRepository.getAllMapItems()
    }

    suspend fun addMarker(toolMarker: MapItem): MutableList<MapItem>{
        return mapItemRepository.createMapItem(
            MapItemCreateInput(
                itemType = toolMarker.itemType,
                latitude = toolMarker.latitude,
                longitude = toolMarker.longitude,
                userName = toolMarker.userName,
                userSchool = toolMarker.userSchool
            )
        )
    }
}