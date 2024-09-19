package com.example.lesson4.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String,
    homeTabContent: @Composable () -> Unit,
    favouriteTabContent: @Composable () -> Unit,
    profileTabContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable(Tabs.Home.route) { homeTabContent() }

        composable(Tabs.Favourite.route) { favouriteTabContent() }

        composable(Tabs.Profile.route) { profileTabContent() }

    }

}