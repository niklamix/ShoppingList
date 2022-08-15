package com.niklamix.shoppinglist.domain

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopItem (itemId: Int): ShopItem {
        return shopListRepository.getShopItem(itemId)
    }
}