package com.cquiro.mealcatalog.domain.repositories

import com.cquiro.mealcatalog.domain.entities.Ingredient

interface IngredientRepository {
    fun findAll(): List<Ingredient>
}