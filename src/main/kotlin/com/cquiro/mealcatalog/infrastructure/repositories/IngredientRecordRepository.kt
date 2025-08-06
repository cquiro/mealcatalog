package com.cquiro.mealcatalog.infrastructure.repositories

import com.cquiro.mealcatalog.infrastructure.records.IngredientRecord
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface IngredientRecordRepository : CrudRepository<IngredientRecord, UUID>