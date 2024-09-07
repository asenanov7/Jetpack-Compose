package com.example.vk_client.presentation.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.vk_client.ui.app_bars.BottomNavigationBar
import com.example.vk_client.presentation.ui.app_bars.ScaffoldTopBar

@Composable
fun MainScreen(content: @Composable (paddingValues: PaddingValues) -> Unit) {
    Scaffold(
        topBar = { ScaffoldTopBar() },
        bottomBar = { BottomNavigationBar() },
    ) {
        content(it)
    }
}

@Composable
fun ModalNavigationDrawerSample(content: @Composable () -> Unit) {
    val iconOfItems = listOf(Icons.Default.AccountCircle, Icons.Default.AccountBox)
    val selectedItemIcon = remember { mutableStateOf(iconOfItems[0]) }

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Column(Modifier.verticalScroll(rememberScrollState())) {
                    Spacer(Modifier.height(12.dp))
                    iconOfItems.forEach { iconItem ->
                        NavigationDrawerItem(
                            icon = { Icon(iconItem, contentDescription = null) },
                            label = { Text(iconItem.name.substringAfterLast(".")) },
                            selected = iconItem == selectedItemIcon.value,
                            onClick = { selectedItemIcon.value = iconItem },
                            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                        )
                    }
                }
            }
        },
        content = content
    )
}
