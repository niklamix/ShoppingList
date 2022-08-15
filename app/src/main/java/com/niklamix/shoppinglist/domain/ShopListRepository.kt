package com.niklamix.shoppinglist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    fun addShopItem(item: ShopItem)

    fun editShopItem(item: ShopItem)

    fun getShopItem(itemId: Int): ShopItem

    fun getShopList(): LiveData<List<ShopItem>>

    fun removeShopItem(item: ShopItem)
}