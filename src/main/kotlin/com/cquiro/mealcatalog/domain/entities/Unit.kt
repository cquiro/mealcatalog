package com.cquiro.mealcatalog.domain.entities

enum class Unit(val fullName: String, val symbol: String) {
    GRAM("Gram", "g"),
    TEASPOON("Teaspoon", "tsp"),
    TABLESPOON("Tablespoon", "tbsp"),
    CUP("Cup", "cup"),
    MILLILITER("Milliliter", "mL"),
    LITER("Liter", "L"),
    PINCH("Pinch", "pinch"),
}