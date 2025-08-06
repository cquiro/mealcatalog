package com.cquiro.mealcatalog.infrastructure.repositories

import com.cquiro.mealcatalog.domain.entities.Ingredient
import com.cquiro.mealcatalog.domain.repositories.IngredientRepository
import org.springframework.stereotype.Repository

@Repository
class JdbcIngredientRepository(
    val ingredientRecordRepository: IngredientRecordRepository
) : IngredientRepository {
    override fun findAll(): List<Ingredient> =
        ingredientRecordRepository.findAll().map { it.toDomain() }
}