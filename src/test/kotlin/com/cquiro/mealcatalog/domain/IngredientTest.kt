package com.cquiro.mealcatalog.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class IngredientTest {

    @ParameterizedTest
    @MethodSource("testCases")
    fun `throws exception when instantiated with an invalid value`(
        values: Map<String, Int>,
        expectedMessage: String,
    ) {
        val exception = assertThrows<IllegalArgumentException> {
            Ingredient(
                name = "Olive Oil",
                unit = Unit.TEASPOON,
                proteinPer100g = values["protein"]!!,
                saturatedFatPer100g = values["saturatedFat"]!!,
                fiberPer100g = values["fiber"]!!,
                addedSugarPer100g = values["addedSugar"]!!,
            )
        }

        assertEquals(expectedMessage, exception.message)
    }

    companion object {
        @JvmStatic
        fun testCases(): List<Arguments> =
            listOf(
                Arguments.of(
                    mapOf(
                        "protein" to -10,
                        "saturatedFat" to 10,
                        "fiber" to 10,
                        "addedSugar" to 10,
                    ),
                    "Protein cannot be negative",
                ),
                Arguments.of(
                    mapOf(
                        "protein" to 10,
                        "saturatedFat" to -10,
                        "fiber" to 10,
                        "addedSugar" to 10,
                    ),
                    "Saturated fat cannot be negative",
                ),
                Arguments.of(
                    mapOf(
                        "protein" to 10,
                        "saturatedFat" to 10,
                        "fiber" to -10,
                        "addedSugar" to 10,
                    ),
                    "Fiber cannot be negative",
                ),
                Arguments.of(
                    mapOf(
                        "protein" to 10,
                        "saturatedFat" to 10,
                        "fiber" to 10,
                        "addedSugar" to -10,
                    ),
                    "Added sugar cannot be negative",
                ),
            )
    }
}