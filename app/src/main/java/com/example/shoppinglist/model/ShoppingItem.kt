package com.example.shoppinglist.model

data class ShoppingItem(
    val id:Int,
    val name:String,
    val aisleNumber:Int,
    //resource id, not the best solution
    val image: Int
)