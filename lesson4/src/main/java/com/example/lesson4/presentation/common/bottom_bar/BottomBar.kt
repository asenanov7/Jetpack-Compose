package com.example.lesson4.presentation.common.bottom_bar

import androidx.compose.material.icons.Icons
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun BottomBar() {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background
    ) {
        val selectedItem = remember { mutableIntStateOf(0) }
        val items = listOf(BottomNavigationItem.Home, BottomNavigationItem.Person, BottomNavigationItem.Favorite)

        items.forEachIndexed { index, bottomNavigationItem ->
            NavigationBarItem(
                label = { Text(text = bottomNavigationItem.label) },
                selected = selectedItem.intValue == index,
                onClick = { selectedItem.intValue = index },
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

sealed class BottomNavigationItem(
    val icon: ImageVector,
    val label: String,
) {

    data object Home : BottomNavigationItem(Icons.Default.Home, "Home")
    data object Favorite : BottomNavigationItem(Icons.Default.Favorite, "Favorite")
    data object Person : BottomNavigationItem(Icons.Default.Person, "Person")
}