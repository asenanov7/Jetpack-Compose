package com.example.lesson4.common.bottom_bar

import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(navHostController: NavHostController) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background
    ) {
        val backStack by navHostController.currentBackStackEntryAsState()
        val selectedItem = backStack?.destination?.route

        val items = listOf(BottomNavigationItem.Home, BottomNavigationItem.Profile, BottomNavigationItem.Favorite)

        items.forEach { bottomNavigationItem ->
            NavigationBarItem(
                label = { Text(text = bottomNavigationItem.label) },
                selected = selectedItem.toString() == bottomNavigationItem.screen.route,
                onClick = { navHostController.navigate(bottomNavigationItem.screen.route) },
                icon = { Icon(bottomNavigationItem.icon, null) },
                colors = NavigationBarItemColors(
                    selectedIconColor = MaterialTheme.colorScheme.background,
                    selectedTextColor = MaterialTheme.colorScheme.onBackground,
                    selectedIndicatorColor = MaterialTheme.colorScheme.onBackground,
                    unselectedIconColor = MaterialTheme.colorScheme.onBackground,
                    unselectedTextColor = MaterialTheme.colorScheme.onBackground,
                    disabledIconColor = MaterialTheme.colorScheme.tertiary,
                    disabledTextColor = MaterialTheme.colorScheme.tertiary,
                )
            )
        }
    }
}
