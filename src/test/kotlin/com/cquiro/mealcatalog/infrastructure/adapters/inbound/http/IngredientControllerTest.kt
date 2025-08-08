package com.cquiro.mealcatalog.infrastructure.adapters.inbound.http

import com.cquiro.mealcatalog.domain.entities.Unit
import com.cquiro.mealcatalog.domain.repositories.IngredientRepository
import com.cquiro.mealcatalog.factories.domain.createIngredient
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

class IngredientControllerTest {
    lateinit var mockMvc: MockMvc
    lateinit var ingredientRepository: IngredientRepository

    @BeforeEach
    fun setUp() {
        ingredientRepository = mockk()
        val controller = IngredientController(ingredientRepository)
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build()
    }

    @Test
    fun `should return 200 OK with ingredient DTOs`() {
        val ingredient = createIngredient()

        every { ingredientRepository.findAll() } returns listOf(ingredient)

        mockMvc
            .perform(get("/ingredients"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].name").value(ingredient.name))
            .andExpect(jsonPath("$[0].unit").value(Unit.GRAM.symbol))
    }
}
