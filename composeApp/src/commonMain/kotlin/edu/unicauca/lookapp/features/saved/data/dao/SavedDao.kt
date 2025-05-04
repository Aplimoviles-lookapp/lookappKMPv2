package edu.unicauca.lookapp.features.saved.data.dao

import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import edu.unicauca.lookapp.features.userprofile.data.dao.UserAccountDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map


class SavedDao(private val userAccountDao: UserAccountDao) {

    fun getSavedItems(userId: Long): Flow<List<ItemEntity>> {
        return userAccountDao.getAll().map { userList ->
            userList.find { it.userAccountId == userId }?.savedItems ?: emptyList()
        }
    }
    suspend fun deleteItem(userId:Long,id:Long){
        val currentList = userAccountDao.getAll().first().toMutableList()

        val index = currentList.indexOfFirst { it.userAccountId == userId }
        if (index != -1) {
            val user = currentList[index]
            val updatedItems = user.savedItems.filterNot { it.itemId == id }
            currentList[index] = user.copy(savedItems = updatedItems)

           // userAccountDao.updateAll(currentList)
        }
    }
}