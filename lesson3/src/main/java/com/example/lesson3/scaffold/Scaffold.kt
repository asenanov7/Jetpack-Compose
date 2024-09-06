package com.example.lesson3.scaffold

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun MyScaffold() {
    ModalNavigationDrawerSample {
        Scaffold(
            topBar = { ScaffoldTopBar() },
            bottomBar = { ScaffoldBottomBar() },
        ) {

            Text(
                modifier = Modifier.padding(it),
                text = "This is Scaffold Content"
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun ScaffoldTopBar() {
    TopAppBar(
        title = { Text(text = "asdasd") },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Menu, null)
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

@Preview
@Composable
private fun ScaffoldBottomBar() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Songs", "Artists", "Playlist")
    val selectedIcons = listOf(Icons.Filled.Home, Icons.Filled.Favorite, Icons.Filled.Star)
    val unselectedIcons = listOf(Icons.Outlined.Home, Icons.Outlined.Favorite, Icons.Outlined.Star)

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == selectedItem,
                label = { Text(text = item) },
                onClick = { selectedItem = index },
                icon = {
                    Icon(
                        imageVector = if (index == selectedItem) selectedIcons[index] else unselectedIcons[index],
                        contentDescription = null
                    )
                })
        }
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
