package edu.unicauca.lookapp.features.userprofile.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import edu.unicauca.lookapp.core.ui.components.BottomNavBar
import edu.unicauca.lookapp.core.ui.components.TopAppBar
import edu.unicauca.lookapp.core.utils.SessionManager
import edu.unicauca.lookapp.features.userprofile.ui.viewmodel.UserProfileViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun UserProfileScreen(modifier: Modifier = Modifier, userProfileViewModel: UserProfileViewModel = koinViewModel(), ) {
    val userAccounts = userProfileViewModel.getUserAccounts().collectAsState(
        initial = emptyList()
    )
    val uiState by userProfileViewModel.currentUser.collectAsState()
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surfaceContainerLowest)
    ) {
        item(key = uiState.currentUserAccount?.email ?: "default") {
            MyAccountSection(userName = (uiState.currentUserAccount?.name) ?: "Anonymous")
        }
        item {
            //TODO: Sacar las accounts del viewmodel
            AccountsSection(
                accounts = userAccounts.value,
                onClickedAddAccount = { userProfileViewModel.addUserAccount() },
                onClickedLoggoutAll = { userProfileViewModel.signoutAllAccounts() },
                onClickedAccount = { userAccount ->
                    userProfileViewModel.updateUserAccount(userAccount)
                }
            )
        }

    }
}

@Preview()
@Composable
fun UserProfileScreenPreview() {
    Scaffold(
        topBar = { TopAppBar(title = "User Profile") },
        bottomBar = { BottomNavBar() }
    ) { padding ->
        UserProfileScreen(Modifier.padding(padding))
    }
}