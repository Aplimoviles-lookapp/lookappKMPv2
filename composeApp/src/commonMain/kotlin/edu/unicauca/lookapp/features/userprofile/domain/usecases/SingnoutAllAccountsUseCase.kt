package edu.unicauca.lookapp.features.userprofile.domain.usecases

import edu.unicauca.lookapp.features.userprofile.data.repository.UserAccountRepository

class SingnoutAllAccountsUseCase constructor(
    private val userAccountRepository: UserAccountRepository
) {
    suspend operator fun invoke() {
        userAccountRepository.deleteAll()
    }
}