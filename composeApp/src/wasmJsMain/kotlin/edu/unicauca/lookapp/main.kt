package edu.unicauca.lookapp

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import edu.unicauca.lookapp.core.ui.navigation.NavigationApp
import edu.unicauca.lookapp.features.userprofile.di.userModule
import kotlinx.browser.document
import org.koin.core.context.startKoin

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        // Initialize Koin
        startKoin() {
            modules(
                userModule
            )
        }
        NavigationApp()
    }
}