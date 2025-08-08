package com.cquiro.mealcatalog.infrastructure.adapters.outbound.storage.repositories

import com.cquiro.mealcatalog.infrastructure.adapters.outbound.storage.records.IngredientRecord
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface IngredientRecordRepository : CrudRepository<IngredientRecord, UUID>
