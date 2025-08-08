package com.cquiro.mealcatalog.domain.entities

import com.cquiro.mealcatalog.utils.FixedUUID
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class IngredientTest {
    @ParameterizedTest
    @MethodSource("testCases")
    fun `throws exception when instantiated with negative nutritional values`(
        values: Map<String, Int>,
        expectedMessage: String,
    ) {
        val exception =
            assertThrows<IllegalArgumentException> {
                Ingredient(
                    id = FixedUUID.INGREDIENT_UUID,
                    name = "Olive Oil",
                    unit = Unit.TEASPOON,
                    slug = "olive-oil",
                    proteinPer100g = values["protein"]!!,
                    saturatedFatPer100g = values["saturatedFat"]!!,
                    fiberPer100g = values["fiber"]!!,
                    addedSugarPer100g = values["addedSugar"]!!,
                )
            }

        Assertions.assertEquals(expectedMessage, exception.message)
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
