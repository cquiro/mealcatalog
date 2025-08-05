package com.cquiro.mealcatalog.factories.domain

import com.cquiro.mealcatalog.domain.Ingredient
import com.cquiro.mealcatalog.domain.Unit
fun createIngredient(
    name: String = "Chicken Breast",
    unit: Unit = Unit.GRAM,
    proteinPer100g: Int = 31,
    saturatedFatPer100g: Int = 1,
    fiberPer100g: Int = 0,
    addedSugarPer100g: Int = 0,
) = Ingredient(
    name = name,
    unit = unit,
    proteinPer100g = proteinPer100g,
    saturatedFatPer100g = saturatedFatPer100g,
    fiberPer100g = fiberPer100g,
    addedSugarPer100g = addedSugarPer100g,
)