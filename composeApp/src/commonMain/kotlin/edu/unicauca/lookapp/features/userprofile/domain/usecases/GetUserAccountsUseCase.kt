package edu.unicauca.lookapp.features.userprofile.domain.usecases

import edu.unicauca.lookapp.features.userprofile.data.repository.UserAccountRepository

class GetUserAccountsUseCase  constructor (
    private val userAccountRepository: UserAccountRepository
) {
    operator fun invoke() = userAccountRepository.getAll()
}