package com.example.lesson4.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String,
    homeScreenContent: @Composable () -> Unit,
    favouriteScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit,

    ) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable(Screen.Home.route) { homeScreenContent() }

        composable(Screen.Favourite.route) { favouriteScreenContent() }

        composable(Screen.Profile.route) { profileScreenContent() }

    }

}