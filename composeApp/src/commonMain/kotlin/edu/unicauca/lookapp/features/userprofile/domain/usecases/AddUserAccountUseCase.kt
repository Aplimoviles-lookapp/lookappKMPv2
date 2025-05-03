package edu.unicauca.lookapp.features.userprofile.domain.usecases

import edu.unicauca.lookapp.features.userprofile.data.entities.UserAccountEntity
import edu.unicauca.lookapp.features.userprofile.data.repository.UserAccountRepository

class AddUserAccountUseCase constructor(
    private val userAccountRepository: UserAccountRepository
) {
    private val randomAccounts = listOf(
        UserAccountEntity(name = "John Doe", email = "john.doe@example.com", savedItems = emptyList()),
        UserAccountEntity(name = "Jane Smith", email = "jane.smith@example.com", savedItems = emptyList()),
        UserAccountEntity(name = "Alice Johnson", email = "alice.johnson@example.com", savedItems = emptyList()),
        UserAccountEntity(name = "Bob Brown", email = "bob.brown@example.com", savedItems = emptyList()),
    )

    suspend operator fun invoke() {
        userAccountRepository.insertUserAccount(randomAccounts.random())
    }

}