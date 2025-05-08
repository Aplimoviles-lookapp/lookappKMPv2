package edu.unicauca.lookapp.features.saved.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.unicauca.lookapp.core.utils.SessionManager
import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import edu.unicauca.lookapp.features.saved.domain.usescases.AddItemToUserUseCase
import edu.unicauca.lookapp.features.saved.domain.usescases.DeleteSavedUseCase
import edu.unicauca.lookapp.features.saved.domain.usescases.GetSavedUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class SavedViewModel constructor(
    private val getSavedUseCase: GetSavedUseCase,
    private val deleteSavedUseCase:DeleteSavedUseCase,
    private val addItemToUserUseCase: AddItemToUserUseCase,
    val sessionManager: SessionManager
)  : ViewModel(){

    fun getSavedItems(): Flow<List<ItemEntity>> {
        val userId = sessionManager.uiState.value.currentUserAccount?.id
        println("Obteniendo items para el usuario con ID: $userId")
        return getSavedUseCase(sessionManager.uiState.value.currentUserAccount?.id ?:0)
    }
   fun deleteItem(id:Long) {
       viewModelScope.launch {
           deleteSavedUseCase(sessionManager.uiState.value.currentUserAccount?.id ?: 0, id)
       }
   }

    fun addDummyItem() {
        viewModelScope.launch {
            addItemToUserUseCase(sessionManager.uiState.value.currentUserAccount?.id ?:0)
        }
    }

}