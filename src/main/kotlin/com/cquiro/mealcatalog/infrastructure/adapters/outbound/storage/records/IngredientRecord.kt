package com.cquiro.mealcatalog.infrastructure.adapters.outbound.storage.records

import com.cquiro.mealcatalog.domain.entities.Ingredient
import com.cquiro.mealcatalog.domain.entities.Unit
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table("ingredients")
data class IngredientRecord(
    @Id val id: UUID,
    val slug: String,
    val name: String,
    val unit: String,
    @Column("protein_per_100g")
    val proteinPer100g: Int,
    @Column("saturated_fat_per_100g")
    val saturatedFatPer100g: Int,
    @Column("fiber_per_100g")
    val fiberPer100g: Int,
    @Column("added_sugars_per_100g")
    val addedSugarsPer100g: Int,
) {
    fun toDomain() =
        Ingredient(
            id = id,
            name = name,
            unit = Unit.fromString(unit),
            slug = slug,
            proteinPer100g = proteinPer100g,
            saturatedFatPer100g = saturatedFatPer100g,
            fiberPer100g = fiberPer100g,
            addedSugarPer100g = addedSugarsPer100g,
        )

    companion object {
        fun fromDomain(ingredient: Ingredient) =
            with(ingredient) {
                IngredientRecord(
                    id = id,
                    slug = slug,
                    name = name,
                    unit = unit.fullName,
                    proteinPer100g = proteinPer100g,
                    saturatedFatPer100g = saturatedFatPer100g,
                    fiberPer100g = fiberPer100g,
                    addedSugarsPer100g = addedSugarPer100g,
                )
            }
    }
}
