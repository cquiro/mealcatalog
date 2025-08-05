package com.cquiro.mealcatalog.domain.entities

data class Recipe(
    val ingredients: Map<Int, Ingredient>,
    val instructions: String,
    val servings: Int,
)