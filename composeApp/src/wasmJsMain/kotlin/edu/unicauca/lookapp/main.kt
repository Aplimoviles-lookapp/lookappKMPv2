package edu.unicauca.lookapp

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import edu.unicauca.lookapp.core.ui.navigation.NavigationApp
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        NavigationApp()
    }
}