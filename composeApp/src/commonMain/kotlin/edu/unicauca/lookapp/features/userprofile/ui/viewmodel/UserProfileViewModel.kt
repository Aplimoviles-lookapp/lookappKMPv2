package edu.unicauca.lookapp.features.userprofile.ui.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.unicauca.lookapp.core.utils.SessionManager
import edu.unicauca.lookapp.features.userprofile.domain.usecases.AddUserAccountUseCase
import edu.unicauca.lookapp.features.userprofile.domain.usecases.GetUserAccountsUseCase
import edu.unicauca.lookapp.features.userprofile.domain.usecases.SingnoutAllAccountsUseCase
import edu.unicauca.lookapp.features.userprofile.ui.screen.UserAccount

import kotlinx.coroutines.launch

class UserProfileViewModel constructor(
    private val addUserAccountUseCase: AddUserAccountUseCase,
    private val getUserAccountsUseCase: GetUserAccountsUseCase,
    private val singnoutAllAccountsUseCase: SingnoutAllAccountsUseCase,
    private val sessionManager: SessionManager,

    ) : ViewModel() {

    val currentUser = sessionManager.uiState

    fun addUserAccount() {
        viewModelScope.launch {
            addUserAccountUseCase()
        }
    }
    fun signoutAllAccounts() {
        viewModelScope.launch {
            singnoutAllAccountsUseCase()
            sessionManager.updateUserAccount(null)
        }
    }

    fun getUserAccounts() = getUserAccountsUseCase()
    fun updateUserAccount(userAccount: UserAccount?) {
        sessionManager.updateUserAccount(userAccount)
    }
}

