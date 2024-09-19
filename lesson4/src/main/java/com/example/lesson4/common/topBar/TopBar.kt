package com.example.lesson4.common.topBar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.lesson4.navigation.NavigationState

@ExperimentalMaterial3Api
@Composable
fun TopBar(navigationState: NavigationState) {

    val backStack by navigationState.navHostController.currentBackStackEntryAsState()
    val currentRoute = backStack?.destination?.route.toString()

    val topBarSettings = getTopBarSettings(currentRoute)

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
        title = { Text(text = topBarSettings.text) },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(topBarSettings.navigationIcon, null)
            }
        },
    )
}



