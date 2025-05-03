package edu.unicauca.lookapp.core.utils

import androidx.lifecycle.ViewModel
import edu.unicauca.lookapp.features.userprofile.domain.usecases.LoadInitialUserAccountsUseCase
import edu.unicauca.lookapp.features.userprofile.ui.screen.UserAccount
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class SessionManager  constructor (
   // private val loadInitialServiceUseCase:LoadInitialServiceUseCase
): ViewModel(){
    private val _uiState = MutableStateFlow(UserProfileUiState())
    val uiState: StateFlow<UserProfileUiState> = _uiState.asStateFlow()

    /*fun loadInitialData() {
        // This function is called when the app starts to load initial data
        // they must be launched in their own coroutine scope sequeentially
        /*viewModelScope.launch {
            loadInitialSavedItemsUseCase()
        }*/

        viewModelScope.launch {
            loadInitialSavedItemsUseCase() // Inserta Items primero
            loadInitialUserAccountsUseCase() // Luego crea usuarios con esos Items
        }
    }*/

    fun updateUserAccount(newUserAccount: UserAccount?) {


        _uiState.value = _uiState.value.copy(currentUserAccount = newUserAccount)

    }

}

data class UserProfileUiState(public var currentUserAccount: UserAccount? = null)