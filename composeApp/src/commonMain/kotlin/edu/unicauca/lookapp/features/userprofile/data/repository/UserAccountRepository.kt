package edu.unicauca.lookapp.features.userprofile.data.repository

import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import edu.unicauca.lookapp.features.userprofile.data.datasource.UserAccountDataSource
import edu.unicauca.lookapp.features.userprofile.data.entities.UserAccountEntity
import edu.unicauca.lookapp.features.userprofile.data.prepopulate.InitialUserAccountDataProvider
import edu.unicauca.lookapp.features.userprofile.ui.screen.UserAccount
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class UserAccountRepository  constructor(
    private val userAccountDataSource: UserAccountDataSource
) {
    init {
        CoroutineScope(Dispatchers.Default).launch{
            loadInitialData()
        }
    }


    suspend fun insertUserAccount(userAccount: UserAccountEntity) {
        userAccountDataSource.insertUserAccount(userAccount)
    }

    suspend fun loadInitialData() {
        if (userAccountDataSource.count() > 0) return
        val user: UserAccountEntity = InitialUserAccountDataProvider.getAccounts()[0]
        userAccountDataSource.insertUserAccount(user)


    }




    suspend fun deleteAll() {
        userAccountDataSource.deleteAll()
    }

    fun getAll() = userAccountDataSource.getAll().map { entities ->
        entities.map { entity ->
            UserAccount(
                id = entity.userAccountId,
                name = entity.name,
                email = entity.email,
                onClick = { callback-> callback(entity.userAccountId) }
            )
        }
    }
}