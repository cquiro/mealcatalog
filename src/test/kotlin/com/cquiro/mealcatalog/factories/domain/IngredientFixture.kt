package com.cquiro.mealcatalog.factories.domain

import com.cquiro.mealcatalog.domain.entities.Ingredient
import com.cquiro.mealcatalog.domain.entities.Unit
import com.cquiro.mealcatalog.utils.FixedUUID
import java.util.UUID

fun createIngredient(
    id: UUID = FixedUUID.INGREDIENT_UUID,
    name: String = "Chicken Breast",
    unit: Unit = Unit.GRAM,
    slug: String = "chicken-breast",
    proteinPer100g: Int = 31,
    saturatedFatPer100g: Int = 1,
    fiberPer100g: Int = 0,
    addedSugarPer100g: Int = 0,
) = Ingredient(
    id = id,
    name = name,
    unit = unit,
    slug = slug,
    proteinPer100g = proteinPer100g,
    saturatedFatPer100g = saturatedFatPer100g,
    fiberPer100g = fiberPer100g,
    addedSugarPer100g = addedSugarPer100g,
)