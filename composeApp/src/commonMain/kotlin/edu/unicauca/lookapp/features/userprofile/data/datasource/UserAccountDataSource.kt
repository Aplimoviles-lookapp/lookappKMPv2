package edu.unicauca.lookapp.features.userprofile.data.datasource

import edu.unicauca.lookapp.features.userprofile.data.entities.UserAccountEntity
import kotlinx.coroutines.flow.Flow

interface UserAccountDataSource {
    suspend fun insertUserAccount(userAccount: UserAccountEntity)
    suspend fun count(): Int
    suspend fun deleteAll()
    fun getAll(): Flow<List<UserAccountEntity>>
}