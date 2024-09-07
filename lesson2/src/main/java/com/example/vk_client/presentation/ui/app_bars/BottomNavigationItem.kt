package com.example.vk_client.ui.app_bars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItem(
    val icon: ImageVector,
    val label: String,
) {
    data object Home : BottomNavigationItem(Icons.Default.Home, "Home")
    data object Favorite : BottomNavigationItem(Icons.Default.Favorite, "Favorite")
    data object Person : BottomNavigationItem(Icons.Default.Person, "Person")
}