package edu.unicauca.lookapp.features.saved.di



import edu.unicauca.lookapp.core.utils.SessionManager
import edu.unicauca.lookapp.features.saved.data.dao.SavedDao
import edu.unicauca.lookapp.features.saved.data.datasource.RoomSavedLocalDataSourceImpl
import edu.unicauca.lookapp.features.saved.data.datasource.SavedDataSource
import edu.unicauca.lookapp.features.saved.data.repository.SavedRepository
import edu.unicauca.lookapp.features.saved.domain.usescases.AddItemToUserUseCase
import edu.unicauca.lookapp.features.saved.domain.usescases.DeleteSavedUseCase
import edu.unicauca.lookapp.features.saved.domain.usescases.GetSavedUseCase
import edu.unicauca.lookapp.features.saved.ui.viewmodel.SavedViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val savedModule = module {
    singleOf(::SavedDao)
    singleOf(::RoomSavedLocalDataSourceImpl).bind<SavedDataSource>()
    singleOf(::SavedRepository)
    singleOf(::SessionManager)

    factoryOf(::GetSavedUseCase)
    factoryOf(::DeleteSavedUseCase)
    factoryOf(::AddItemToUserUseCase)

    viewModelOf(::SavedViewModel)


}