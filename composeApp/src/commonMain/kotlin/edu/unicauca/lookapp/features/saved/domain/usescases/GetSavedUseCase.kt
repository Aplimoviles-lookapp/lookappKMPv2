package edu.unicauca.lookapp.features.saved.domain.usescases

import edu.unicauca.lookapp.features.saved.data.repository.SavedRepository

class GetSavedUseCase constructor(private val savedRepository: SavedRepository){
    operator fun invoke(userId:Long)=savedRepository.getSavedItems(userId)

}