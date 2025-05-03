package edu.unicauca.lookapp.features.userprofile.domain.usecases

import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import edu.unicauca.lookapp.features.userprofile.data.repository.UserAccountRepository
import kotlinx.coroutines.flow.first

class LoadInitialUserAccountsUseCase constructor(
    private val userAccountRepository: UserAccountRepository,
) {
    suspend operator fun invoke() {

        userAccountRepository.loadInitialData()
    }
}