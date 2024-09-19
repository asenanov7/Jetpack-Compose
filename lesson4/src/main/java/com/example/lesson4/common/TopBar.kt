package com.example.lesson4.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.lesson4.navigation.NavigationState
import com.example.lesson4.navigation.Screen

@ExperimentalMaterial3Api
@Composable
fun TopBar(navigationState: NavigationState) {

    val backStack by navigationState.navHostController.currentBackStackEntryAsState()
    val currentRoute = backStack?.destination?.route.toString()

    val topBarSettings= getTopBarSettings(currentRoute)

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
        title = { Text(text = topBarSettings.text) },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(topBarSettings.navigationIcon, null)
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Favorite, null)
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.AccountBox, null)
            }
        }
    )
}

private fun getTopBarSettings(currentRoute: String): TopBarSettings {
    return when (currentRoute) {
        Screen.Home.route -> {
            TopBarSettings("Home")
        }
        Screen.Profile.route -> {
            TopBarSettings("Profile")
        }
        Screen.Favourite.route -> {
            TopBarSettings("Favourite")
        }
        Screen.Comments.route -> {
            TopBarSettings("Comments")
        }
        else -> {
            TopBarSettings("")
        }
    }
}

data class TopBarSettings(
    val text: String,
    val navigationIcon: ImageVector = Icons.AutoMirrored.Filled.ArrowBack,
)