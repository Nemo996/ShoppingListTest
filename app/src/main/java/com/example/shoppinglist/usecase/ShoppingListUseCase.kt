package com.example.shoppinglist.usecase

import com.example.shoppinglist.R
import com.example.shoppinglist.model.ShoppingItem

class ShoppingListUseCase {

    fun getShoppingList(sort: Sorting = Sorting.NONE): List<ShoppingItem> {
        return when (sort) {
                Sorting.ALPHABETIC -> getList().sortedBy { it.name }
                Sorting.AISLE -> getList().sortedBy { it.aisleNumber }
                else -> getList()
        }
    }

    private fun getList(): List<ShoppingItem> {
        return listOf(
            ShoppingItem(
                id = 1,
                name = "Cheese",
                aisleNumber = 1,
                image = R.drawable.cheese
            ),
            ShoppingItem(
                id = 2,
                name = "Milk",
                aisleNumber = 1,
                image = R.drawable.milk_bottle
            ),
            ShoppingItem(
                id = 3,
                name = "Yogurt",
                aisleNumber = 1,
                image = R.drawable.milk_bottle
            ),
            ShoppingItem(
                id = 4,
                name = "Bread",
                aisleNumber = 2,
                image = R.drawable.bread
            ),
            ShoppingItem(
                id = 5,
                name = "Beer",
                aisleNumber = 2,
                image = R.drawable.milk_bottle
            ),
            ShoppingItem(
                id = 6,
                name = "Sausage",
                aisleNumber = 3,
                image = R.drawable.cheese
            ),
            ShoppingItem(
                id = 7,
                name = "Buns",
                aisleNumber = 3,
                image = R.drawable.bread
            )
        )
    }
}

enum class Sorting {
    NONE,
    ALPHABETIC,
    AISLE
}
