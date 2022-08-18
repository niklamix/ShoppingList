package com.niklamix.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.niklamix.shoppinglist.domain.ShopItem
import com.niklamix.shoppinglist.domain.ShopListRepository
import java.lang.RuntimeException
import java.util.*
import kotlin.random.Random


object ShopListRepositoryImpl : ShopListRepository {
    private val shopListLD = MutableLiveData<List<ShopItem>>()
    private val shopList = sortedSetOf<ShopItem>({ o1, o2 -> o1.id.compareTo(o2.id) })

    private var autoIncrementId = 0

    init {
        for (i in 0 until 10) {
            val item = ShopItem("Name $i", i, Random.nextBoolean())
            addShopItem(item)
        }
    }

    override fun addShopItem(item: ShopItem) {
        if (item.id == ShopItem.UNDEFINED_ID) {
            item.id = autoIncrementId++
        }
        shopList.add(item)
        updateList()
    }

    override fun editShopItem(item: ShopItem) {
        val oldElement = getShopItem(item.id)
        shopList.remove(oldElement)
        addShopItem(item)
    }

    override fun getShopItem(itemId: Int): ShopItem {
        return shopList.find { it.id == itemId }
            ?: throw RuntimeException("Element with id $itemId not found")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    override fun removeShopItem(item: ShopItem) {
        shopList.remove(item)
        updateList()
    }
    private fun updateList() {
        shopListLD.value = shopList.toList()
    }
}