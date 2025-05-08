package edu.unicauca.lookapp.features.userprofile.data.dao


import edu.unicauca.lookapp.features.userprofile.data.entities.UserAccountEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow


class UserAccountDao {

    private val userAccounts = MutableStateFlow<MutableList<UserAccountEntity>>(mutableListOf())

    suspend fun insertUserAccount(userAccount: UserAccountEntity) {
        val updatedList = userAccounts.value.toMutableList()
        val newId = if (updatedList.isEmpty()) 1L else (updatedList.maxOf { it.userAccountId } + 1)
        val userWithId = userAccount.copy(userAccountId = newId)
        updatedList.add(userWithId)
        userAccounts.value = updatedList
    }

    fun getAll(): Flow<List<UserAccountEntity>> {
        return userAccounts
    }

    suspend fun deleteAll(){
        userAccounts.value = mutableListOf()
    }

    suspend fun updateAll(users: List<UserAccountEntity>) {
        userAccounts.value = users.toMutableList()
    }

    suspend fun count(): Int{
        return userAccounts.value.size
    }

}