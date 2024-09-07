package com.example.bottom_navigation_bar

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember

@Composable
fun BottomNavigationBar() {
    NavigationBar {
        val selectedItem = remember { mutableIntStateOf(0) }
        val items = listOf(BottomNavigationItem.Home, BottomNavigationItem.Person, BottomNavigationItem.Favorite)

        items.forEachIndexed { index, bottomNavigationItem ->
            NavigationBarItem(
                label = { Text(text = bottomNavigationItem.label) },
                selected = selectedItem.intValue == index,
                onClick = { selectedItem.intValue = index },
                icon = { Icon(bottomNavigationItem.icon, null) },
                colors = NavigationBarItemColors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    selectedIndicatorColor = MaterialTheme.colorScheme.onPrimary,
                    unselectedIconColor = MaterialTheme.colorScheme.secondary,
                    unselectedTextColor = MaterialTheme.colorScheme.secondary,
                    disabledIconColor = MaterialTheme.colorScheme.tertiary,
                    disabledTextColor = MaterialTheme.colorScheme.tertiary,
                )
            )
        }
    }
}