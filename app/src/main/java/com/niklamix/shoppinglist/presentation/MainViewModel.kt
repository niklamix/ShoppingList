package com.niklamix.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import com.niklamix.shoppinglist.data.ShopListRepositoryImpl
import com.niklamix.shoppinglist.domain.EditShopItemUseCase
import com.niklamix.shoppinglist.domain.GetShopListUseCase
import com.niklamix.shoppinglist.domain.RemoveShopItemUseCase
import com.niklamix.shoppinglist.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val removeShopItemUseCase = RemoveShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun removeShopList(item: ShopItem) {
        removeShopItemUseCase.removeShopItem(item)
    }

    fun changeEnableState(item: ShopItem) {
        val newItem = item.copy(enabled = !item.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}