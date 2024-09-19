package com.example.lesson4.navigation

sealed class Tabs(
    val route: String,
) {

    data object Home : Tabs(HOME_ROUTE)
    data object Favourite : Tabs(FAVOURITE_ROUTE)
    data object Profile : Tabs(PROFILE_ROUTE)

    companion object ScreenRoutes {

        const val HOME_ROUTE = "HOME_ROUTE"
        const val FAVOURITE_ROUTE = "FAVOURITE_ROUTE"
        const val PROFILE_ROUTE = "PROFILE_ROUTE"

    }
}