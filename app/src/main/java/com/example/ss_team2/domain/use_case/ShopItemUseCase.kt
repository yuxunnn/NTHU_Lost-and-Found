package com.example.ss_team2.domain.use_case


//感覺可以不用這個
class ShopItemUseCase {
    private val shopItemRepository = ShopItemRepository()

    suspend fun getShopItems(): List<ShopItem>{
        return shopItemRepository.shopItems()
    }
}