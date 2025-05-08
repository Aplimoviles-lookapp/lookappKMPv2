package edu.unicauca.lookapp.features.saved.data.datasource

import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import kotlinx.coroutines.flow.Flow

interface SavedDataSource {
    fun getSavedItems(userId: Long): Flow<List<ItemEntity>>
    suspend fun deleteItem(userId:Long,id:Long)
    suspend fun addItem(userId: Long)
}