package com.example.lesson4.common.topBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.lesson4.navigation.Tabs

data class TopBarSettings(
    val text: String,
    val navigationIcon: ImageVector = Icons.AutoMirrored.Filled.ArrowBack,
)

fun getTopBarSettings(currentRoute: String): TopBarSettings {
    return when (currentRoute) {
        Tabs.Home.route -> {
            TopBarSettings("Home")
        }
        Tabs.Profile.route -> {
            TopBarSettings("Profile")
        }
        Tabs.Favourite.route -> {
            TopBarSettings("Favourite")
        }
        else -> {
            TopBarSettings("")
        }
    }
}