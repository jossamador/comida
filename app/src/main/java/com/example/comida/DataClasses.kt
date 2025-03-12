

package com.example.comida

data class Category(
    val name: String,
    val imageUrl: String
)

data class Restaurant(
    val name: String,
    val imageUrl: String
)

data class Food(
    val name: String,
    val imageUrl: String,
    val rating: Float,
    val price: Double
)