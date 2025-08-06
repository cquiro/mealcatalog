package com.cquiro.mealcatalog.infrastructure.records

import com.cquiro.mealcatalog.domain.entities.Ingredient
import com.cquiro.mealcatalog.domain.entities.Unit
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID


@Table("ingredients")
data class IngredientRecord(
    @Id val id: UUID,
    val slug: String,
    val name: String,
    val unit: String,
    val proteinPer100g: Int,
    val saturatedFatPer100g: Int,
    val fiberPer100g: Int,
    val addedSugarsPer100g: Int,
) {
    fun toDomain() =
        Ingredient(
            name = name,
            unit = Unit.fromString(unit),
            slug = slug,
            proteinPer100g = proteinPer100g,
            saturatedFatPer100g = saturatedFatPer100g,
            fiberPer100g = fiberPer100g,
            addedSugarPer100g = addedSugarsPer100g,
        )

    companion object {
        fun fromDomain(id: UUID, ingredient: Ingredient) =
            IngredientRecord(
                id = id,
                slug = ingredient.slug,
                name = ingredient.name,
                unit = ingredient.unit.fullName,
                proteinPer100g = ingredient.proteinPer100g,
                saturatedFatPer100g = ingredient.saturatedFatPer100g,
                fiberPer100g = ingredient.fiberPer100g,
                addedSugarsPer100g = ingredient.addedSugarPer100g,
            )
    }
}