package edu.unicauca.lookapp.features.userprofile.di


import androidx.lifecycle.viewmodel.compose.viewModel
import edu.unicauca.lookapp.core.utils.SessionManager
import edu.unicauca.lookapp.features.userprofile.data.dao.UserAccountDao
import edu.unicauca.lookapp.features.userprofile.data.datasource.RoomUserAccountLocalDataSourceImpl
import edu.unicauca.lookapp.features.userprofile.data.datasource.UserAccountDataSource
import edu.unicauca.lookapp.features.userprofile.data.repository.UserAccountRepository
import edu.unicauca.lookapp.features.userprofile.domain.usecases.AddUserAccountUseCase
import edu.unicauca.lookapp.features.userprofile.domain.usecases.GetUserAccountsUseCase
import edu.unicauca.lookapp.features.userprofile.domain.usecases.LoadInitialUserAccountsUseCase
import edu.unicauca.lookapp.features.userprofile.domain.usecases.SingnoutAllAccountsUseCase
import edu.unicauca.lookapp.features.userprofile.ui.viewmodel.UserProfileViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module


val userModule = module {
    singleOf(::UserAccountDao)
    singleOf(::RoomUserAccountLocalDataSourceImpl).bind<UserAccountDataSource>()
    single {
        UserAccountRepository(
            get<UserAccountDataSource>()
        )
    }

    single {
        SessionManager()
    }


    factory {
        AddUserAccountUseCase(
            get<UserAccountRepository>()
        )
    }
    factory {
        GetUserAccountsUseCase(
            get<UserAccountRepository>()
        )
    }
    factory {
        LoadInitialUserAccountsUseCase(
            get<UserAccountRepository>())
    }


    factory {
        SingnoutAllAccountsUseCase(
            get<UserAccountRepository>()
        )
    }

    viewModelOf(::UserProfileViewModel)


}
