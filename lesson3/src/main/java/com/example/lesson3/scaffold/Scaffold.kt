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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bottom_navigation_bar.BottomNavigationBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
@Preview
fun MyScaffold() {
    ModalNavigationDrawerSample {
        val snackBarHostState = remember { SnackbarHostState() }
        val fabVisibility = remember { mutableStateOf(true) }
        val coroutineScope = rememberCoroutineScope()

        Scaffold(
            topBar = { ScaffoldTopBar() },
            bottomBar = { BottomNavigationBar() },
            snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
            floatingActionButton = { FloatingButton(snackBarHostState, fabVisibility, coroutineScope) }
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

@Composable
fun FloatingButton(snackBarHostState: SnackbarHostState, fabVisibility: MutableState<Boolean>, coroutineScope: CoroutineScope) {
    if (fabVisibility.value) {
        FloatingActionButton(
            onClick = {
                coroutineScope.launch {
                    val result = snackBarHostState.showSnackbar(
                        message = "Showing snackBar",
                        actionLabel = "OK",
                        withDismissAction = true
                    )
                    if (result == SnackbarResult.ActionPerformed) {
                        fabVisibility.value = false
                    }
                }
            }
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
        }
    }
}
