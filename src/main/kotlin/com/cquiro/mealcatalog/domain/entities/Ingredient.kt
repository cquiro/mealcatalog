package com.cquiro.mealcatalog.domain.entities

class Ingredient(
    val name: String,
    val unit: Unit,
    val proteinPer100g: Int,
    val saturatedFatPer100g: Int,
    val fiberPer100g: Int,
    val addedSugarPer100g: Int,
) {
    init {
        require(proteinPer100g >= 0) { "Protein cannot be negative" }
        require(saturatedFatPer100g >= 0) { "Saturated fat cannot be negative" }
        require(fiberPer100g >= 0) { "Fiber cannot be negative" }
        require(addedSugarPer100g >= 0) { "Added sugar cannot be negative" }
    }
}