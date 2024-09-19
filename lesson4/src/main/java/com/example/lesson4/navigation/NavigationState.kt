package com.example.lesson4.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class NavigationState(
    val navHostController: NavHostController,
) {

    fun navigateTo(route: String) {
        navHostController.navigate(route) {
            //не создает большой паровоз навигации, хранит только последний таб и тот который указ. в параметре
            popUpTo(navHostController.graph.startDestinationRoute.toString()) {
                //сохраняет стейт даже если экран был удален из бекстек
                saveState = true
            }
            //не запускает экран еще раз если он и так сверху стека
            launchSingleTop = true

            //восстанавливает стейт экрана
            restoreState = true
        }
    }

}

@SuppressLint("ComposableNaming")
@Composable
fun rememberNavigationState(navHostController: NavHostController = rememberNavController()): NavigationState {
    return remember { NavigationState(navHostController) }
}
