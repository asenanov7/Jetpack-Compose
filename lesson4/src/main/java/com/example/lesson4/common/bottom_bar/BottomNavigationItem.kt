package com.example.lesson4.common.bottom_bar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.lesson4.navigation.Screen

sealed class BottomNavigationItem(
    val screen: Screen,
    val icon: ImageVector,
    val label: String,
) {

    data object Home : BottomNavigationItem(Screen.Home, Icons.Default.Home, "Home")
    data object Favorite : BottomNavigationItem(Screen.Favourite, Icons.Default.Favorite, "Favorite")
    data object Profile : BottomNavigationItem(Screen.Profile, Icons.Default.Person, "Person")

}