package com.example.ss_team2.data.repository

import com.apollographql.apollo3.ApolloClient
import com.example.ss_team2.ShopItemQuery
import com.example.ss_team2.ShopItemsQuery
import com.example.ss_team2.data.data_source.Post
import com.example.ss_team2.data.data_source.ShopItem

class ShopItemRepository {

    private val apolloClient = ApolloClient.Builder()
        .serverUrl("http://10.0.2.2:3000/graphql").build()

    suspend fun getAllShopItems(): MutableList<ShopItem> {
        val response = apolloClient.query(ShopItemsQuery()).execute()
        println("MySQL Response = ${response.data?.shopItems}")

        val data = response.data?.shopItems
        var shopItemsList: MutableList<ShopItem> = arrayListOf()

        data?.forEach { shopItem ->
            shopItemsList.add(ShopItem(shopItem!!.itemType, shopItem!!.itemPrice))
        }
        return shopItemsList
    }

    suspend fun getShopItemByType(itemType: String): ShopItem{
        val response = apolloClient.query(ShopItemQuery(itemType)).execute()
        println("MySQL Response = ${response.data?.shopItem}")

        val data = response.data?.shopItem

        return ShopItem(data!!.itemType, data.itemPrice)
    }
}