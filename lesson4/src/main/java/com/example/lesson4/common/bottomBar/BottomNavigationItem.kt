package com.example.lesson4.common.bottomBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.lesson4.navigation.Tabs

sealed class BottomNavigationItem(
    val tab: Tabs,
    val icon: ImageVector,
    val label: String,
) {

    data object Home : BottomNavigationItem(Tabs.Home, Icons.Default.Home, "Home")
    data object Favorite : BottomNavigationItem(Tabs.Favourite, Icons.Default.Favorite, "Favorite")
    data object Profile : BottomNavigationItem(Tabs.Profile, Icons.Default.Person, "Person")

}