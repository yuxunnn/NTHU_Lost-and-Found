package com.example.ss_team2.data.repository

import com.apollographql.apollo3.ApolloClient
import com.example.ss_team2.CreateMapItemMutation
import com.example.ss_team2.MapItemsQuery
import com.example.ss_team2.data.data_source.MapItem
import com.example.ss_team2.type.MapItemCreateInput

class MapItemRepository {

    private val apolloClient = ApolloClient.Builder()
        .serverUrl("http://10.0.2.2:3000/graphql").build()

    // Queries
    suspend fun getAllMapItems(): MutableList<MapItem>{
        val response = apolloClient.query(MapItemsQuery()).execute()
        println("MySQL Response = ${response.data?.mapItems}")

        val data = response.data?.mapItems
        var mapItemsList: MutableList<MapItem> = arrayListOf()

        data?.forEach { mapItem ->
            mapItemsList.add(MapItem(
                mapItem!!.itemType,
                mapItem!!.latitude,
                mapItem!!.longitude,
                mapItem!!.userName,
                mapItem!!.userSchool
            ))
        }

        return mapItemsList
    }

    // Mutations
    suspend fun createMapItem(newMapItem: MapItemCreateInput): MutableList<MapItem>{
        val response = apolloClient.mutation(CreateMapItemMutation(newMapItem)).execute()
        println("MySQL Response = ${response.data?.createMapItem}")

        val data = response.data?.createMapItem
        var mapItemsList: MutableList<MapItem> = arrayListOf()

        data?.forEach { mapItem ->
            mapItemsList.add(MapItem(
                mapItem!!.itemType,
                mapItem!!.latitude,
                mapItem!!.longitude,
                mapItem!!.userName,
                mapItem!!.userSchool
            ))
        }

        return  mapItemsList
    }
}