package edu.unicauca.lookapp.features.saved.domain.usescases

import edu.unicauca.lookapp.features.saved.data.repository.SavedRepository

class DeleteSavedUseCase constructor(private val savedRepository: SavedRepository) {
    suspend operator fun invoke(userId:Long,id:Long)=savedRepository.deleteItem(userId,id)

}