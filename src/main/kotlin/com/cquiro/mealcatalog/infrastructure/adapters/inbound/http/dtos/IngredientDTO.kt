package com.cquiro.mealcatalog.infrastructure.adapters.inbound.http.dtos

import com.cquiro.mealcatalog.domain.entities.Ingredient
import java.util.UUID

data class IngredientDTO(
    val id: UUID,
    val name: String,
    val unit: String,
    val slug: String,
    val proteinPer100g: Int,
    val saturatedFatPer100g: Int,
    val fiberPer100g: Int,
    val addedSugarPer100g: Int,
) {
    companion object {
        fun fromDomain(ingredient: Ingredient): IngredientDTO =
            with(ingredient) {
                IngredientDTO(
                    id = id,
                    name = name,
                    unit = unit.symbol,
                    slug = slug,
                    proteinPer100g = proteinPer100g,
                    saturatedFatPer100g = saturatedFatPer100g,
                    fiberPer100g = fiberPer100g,
                    addedSugarPer100g = addedSugarPer100g,
                )
            }
    }
}
