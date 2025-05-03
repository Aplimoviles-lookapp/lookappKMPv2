package edu.unicauca.lookapp.features.userprofile.data.dao


import edu.unicauca.lookapp.features.userprofile.data.entities.UserAccountEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow


class UserAccountDao {

    private val userAccounts = MutableStateFlow<MutableList<UserAccountEntity>>(mutableListOf())

    suspend fun insertUserAccount(userAccount: UserAccountEntity) {
        val updatedList = userAccounts.value.toMutableList()
        updatedList.add(userAccount)
        userAccounts.value = updatedList
    }

    fun getAll(): Flow<List<UserAccountEntity>> {
        return userAccounts
    }

    suspend fun deleteAll(){
        userAccounts.value = mutableListOf()
    }


    suspend fun count(): Int{
        return userAccounts.value.size
    }

}