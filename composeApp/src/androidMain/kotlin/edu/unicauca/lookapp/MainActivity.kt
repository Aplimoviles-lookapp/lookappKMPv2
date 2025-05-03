package edu.unicauca.lookapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import edu.unicauca.lookapp.core.ui.navigation.NavigationApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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