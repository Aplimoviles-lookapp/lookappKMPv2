package edu.unicauca.lookapp.core.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CollectionsBookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

import androidx.navigation.NavOptionsBuilder
import edu.unicauca.lookapp.core.ui.navigation.RouteEnum
import org.jetbrains.compose.ui.tooling.preview.Preview

data class BottomNavItem(val route: String, val icon: ImageVector, val label: String)

@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    currentRoute: String = RouteEnum.Home.route,
    onNavigate: (String,  builder: NavOptionsBuilder.() -> Unit) -> Unit =
        { route, builder ->
            // Handle navigation logic here
        }
) {
    val items = listOf(
        BottomNavItem(RouteEnum.Home.route, Icons.Filled.Home, "Home"),
        BottomNavItem(RouteEnum.Search.route, Icons.Filled.Search, "Search"),
        BottomNavItem(RouteEnum.Saved.route, Icons.Filled.CollectionsBookmark, "Saved"),
        BottomNavItem(
            RouteEnum.Notifications.route, Icons.Filled.Notifications, "Notifications"
        )
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceContainer, modifier = modifier
    ) {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    onNavigate(item.route) {
                        popUpTo(0)
                        launchSingleTop = true
                    }
                },

                )
        }

    }
}


@Preview()
@Composable
fun BottomNavBarPreview() {
    BottomNavBar()
}
