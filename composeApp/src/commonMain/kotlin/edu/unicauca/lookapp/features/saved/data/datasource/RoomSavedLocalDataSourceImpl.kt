package edu.unicauca.lookapp.features.saved.data.datasource

import edu.unicauca.lookapp.features.saved.data.dao.SavedDao
import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import kotlinx.coroutines.flow.Flow

class RoomSavedLocalDataSourceImpl (private val savedDao: SavedDao):SavedDataSource{
    override fun getSavedItems(userId: Long): Flow<List<ItemEntity>> {
        return savedDao.getSavedItems(userId)
    }


}