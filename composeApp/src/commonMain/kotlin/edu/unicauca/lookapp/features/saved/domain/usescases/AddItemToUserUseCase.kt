package edu.unicauca.lookapp.features.saved.domain.usescases

import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import edu.unicauca.lookapp.features.saved.data.repository.SavedRepository

class AddItemToUserUseCase constructor(private val savedRepository: SavedRepository){
    suspend operator fun invoke(userId:Long)=savedRepository.addItem(userId)
}