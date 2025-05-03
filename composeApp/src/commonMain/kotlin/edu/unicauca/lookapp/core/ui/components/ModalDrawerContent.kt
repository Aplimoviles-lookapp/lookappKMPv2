package edu.unicauca.lookapp.core.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Help
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import edu.unicauca.lookapp.core.ui.navigation.RouteEnum
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ModalDrawerContent(
    onNavigate: (String) -> Unit,
    drawerState: DrawerState,
    scope: CoroutineScope,
    modifier: Modifier = Modifier,
) {
    ModalDrawerSheet {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(Modifier.height(12.dp))
            Text(
                "LookApp",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.titleLarge
            )
            HorizontalDivider()

            Text(
                "Atajos",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.titleMedium
            )
            NavigationDrawerItem(
                label = { Text("Home") },
                selected = false,
                onClick = { /* Handle click */ }
            )
            NavigationDrawerItem(
                label = { Text("Search") },
                selected = false,
                onClick = { /* Handle click */ }
            )

            NavigationDrawerItem(
                label = { Text("Reservations") },
                selected = false,
                onClick = { /* Handle click */ }
            )

            NavigationDrawerItem(
                label = { Text("Stylist") },
                selected = false,
                onClick = { /* Handle click */ }
            )

            NavigationDrawerItem(
                label = { Text("Discounts") },
                selected = false,
                onClick = { /* Handle click */ }
            )

            NavigationDrawerItem(
                label = { Text("Saved") },
                selected = false,
                onClick = { /* Handle click */ }
            )

            NavigationDrawerItem(
                label = { Text("Profile") },
                selected = false,
                onClick = { /* Handle click */ }
            )
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

            NavigationDrawerItem(
                label = { Text("Settings") },
                selected = false,
                icon = { Icon(Icons.Outlined.Settings, contentDescription = null) },
                onClick = { /* Handle click */ }
            )
            NavigationDrawerItem(
                label = { Text("Help and feedback") },
                selected = false,
                icon = { Icon(Icons.AutoMirrored.Outlined.Help, contentDescription = null) },
                onClick = { /* Handle click */ },
            )
            NavigationDrawerItem(
                label = { Text("Credits") },
                selected = false,
                icon = { Icon(Icons.Outlined.Info, contentDescription = null) },
                onClick = {
                    scope.launch {
                        drawerState.close()
                        onNavigate(RouteEnum.Credits.route)
                    }
                },
            )
            Spacer(Modifier.height(12.dp))
        }
    }
}

@Preview()
@Composable
fun ModalDrawerContentPreview() {

}