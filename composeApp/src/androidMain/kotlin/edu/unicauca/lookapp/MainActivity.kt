package edu.unicauca.lookapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import edu.unicauca.lookapp.core.ui.navigation.NavigationApp
import edu.unicauca.lookapp.features.userprofile.di.userModule
import org.koin.compose.koinInject
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin() {
            modules(
                userModule
            )
        }
        setContent {
            NavigationApp()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}