package com.cquiro.mealcatalog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MealcatalogApplication

fun main(args: Array<String>) {
    runApplication<MealcatalogApplication>(*args)
}
