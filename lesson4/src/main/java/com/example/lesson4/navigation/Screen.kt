package com.example.lesson4.navigation

sealed class Screen(
    val route: String,
) {

    data object Home : Screen(HOME_ROUTE)
    data object Favourite : Screen(FAVOURITE_ROUTE)
    data object Profile : Screen(PROFILE_ROUTE)

    companion object ScreenRoutes {

        const val HOME_ROUTE = "HOME_ROUTE"
        const val FAVOURITE_ROUTE = "FAVOURITE_ROUTE"
        const val PROFILE_ROUTE = "PROFILE_ROUTE"

    }
}