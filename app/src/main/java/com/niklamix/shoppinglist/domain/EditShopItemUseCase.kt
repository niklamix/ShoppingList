package com.niklamix.shoppinglist.domain

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun editShopItem (item: ShopItem) {
        shopListRepository.editShopItem(item)
    }
}