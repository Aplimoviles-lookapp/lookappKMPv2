package edu.unicauca.lookapp.core.ui.navigation


enum class RouteEnum(val route: String, val title: String) {
    Home("home", "Home"),
    Search("search", "Search"),
    Saved("saved", "Saved"),
    Notifications("notifications","Notifications"),
    Profile("profile", "Profile"),
    Credits("Credits", "Credits");


    companion object {
        private val map = entries.associateBy(RouteEnum::route)
        fun fromRoute(route: String) = map[route]?.title ?: "LookApp"
    }
}