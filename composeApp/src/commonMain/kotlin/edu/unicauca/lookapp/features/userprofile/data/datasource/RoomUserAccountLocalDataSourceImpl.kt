package edu.unicauca.lookapp.features.userprofile.data.datasource

import edu.unicauca.lookapp.features.userprofile.data.dao.UserAccountDao
import edu.unicauca.lookapp.features.userprofile.data.entities.UserAccountEntity
import kotlinx.coroutines.flow.Flow

class RoomUserAccountLocalDataSourceImpl(private val userAccountDao: UserAccountDao) : UserAccountDataSource {
    override suspend fun insertUserAccount(userAccount: UserAccountEntity) {
        userAccountDao.insertUserAccount(userAccount)
    }


    override suspend fun count(): Int {
        return userAccountDao.count()
    }

    override suspend fun deleteAll() {
        userAccountDao.deleteAll()
    }

    override fun getAll(): Flow<List<UserAccountEntity>> {
        return userAccountDao.getAll()
    }




}