package com.example.vk_client.presentation.ui.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.vk_client.presentation.ui.app_bars.ScaffoldTopBar
import com.example.vk_client.presentation.ui.app_bars.BottomNavigationBar

@Composable
fun MainScreen(content: @Composable (paddingValues: PaddingValues) -> Unit) {
    Scaffold(
        topBar = { ScaffoldTopBar() },
        bottomBar = { BottomNavigationBar() },
    ) { paddingValues ->
        content(paddingValues)
    }
}
