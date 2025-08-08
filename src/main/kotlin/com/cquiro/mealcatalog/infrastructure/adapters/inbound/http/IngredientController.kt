package com.cquiro.mealcatalog.infrastructure.adapters.inbound.http

import com.cquiro.mealcatalog.domain.repositories.IngredientRepository
import com.cquiro.mealcatalog.infrastructure.adapters.inbound.http.dtos.IngredientDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ingredients")
class IngredientController(
    private val ingredientRepository: IngredientRepository,
) {
    @GetMapping
    fun getIngredients(): List<IngredientDTO> = ingredientRepository.findAll().map { IngredientDTO.fromDomain(it) }
}
