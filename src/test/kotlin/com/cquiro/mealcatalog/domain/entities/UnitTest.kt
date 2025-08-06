package com.cquiro.mealcatalog.domain.entities

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class UnitTest {

    @ParameterizedTest
    @MethodSource("testCases")
    fun `returns a Unit instance from a valid string`(
        value: String,
        expectedEnum: Unit,
    ) {
        assertEquals(expectedEnum, Unit.fromString(value))
    }

    @Test
    fun `returns a Unit instance from a valid string`() {
        val expectedMessage = "Invalid unit: invalid value"

        val exception = assertThrows<IllegalArgumentException> {
            Unit.fromString("invalid value")
        }

        assertEquals(expectedMessage, exception.message)
    }

    companion object {
        @JvmStatic
        fun testCases(): List<Arguments> =
            listOf(
                Arguments.of(
                "GRAM",
                    Unit.GRAM,
                ),
                Arguments.of(
                "TEASPOON",
                    Unit.TEASPOON,
                ),
                Arguments.of(
                "TABLESPOON",
                    Unit.TABLESPOON,
                ),
                Arguments.of(
                "CUP",
                    Unit.CUP,
                ),
                Arguments.of(
                "MILLILITER",
                    Unit.MILLILITER,
                ),
                Arguments.of(
                "LITER",
                    Unit.LITER,
                ),
                Arguments.of(
                "PINCH",
                    Unit.PINCH,
                ),
            )
    }

}