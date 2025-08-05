package com.cquiro.mealcatalog.domain

enum class Unit(val fullName: String, val symbol: String) {
    GRAM("Gram", "g"),
    TEASPOON("Teaspoon", "tsp"),
    TABLESPOON("tablespoon", "tbsp"),
    CUP("Cup", "cup"),
    MILLILITER("Milliliter", "mL"),
    LITER("Liter", "L"),
    PINCH("Pinch", "pinch"),
}