package com.example.vk_client.presentation.ui.app_bars

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import com.example.vk_client.ui.app_bars.BottomNavigationItem

@Composable
fun BottomNavigationBar() {
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