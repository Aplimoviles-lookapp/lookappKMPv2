package edu.unicauca.lookapp.features.saved.data.repository

import edu.unicauca.lookapp.features.saved.data.datasource.SavedDataSource
import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import kotlinx.coroutines.flow.Flow

class SavedRepository ( private val savedDataSource: SavedDataSource){

    fun getSavedItems(userId: Long): Flow<List<ItemEntity>> {
        return savedDataSource.getSavedItems(userId)
    }
}