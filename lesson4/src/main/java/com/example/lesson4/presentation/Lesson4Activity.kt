@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.lesson4.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.lesson4.presentation.common.TopBar
import com.example.lesson4.presentation.common.bottom_bar.BottomBar
import com.example.lesson4.presentation.screens.HomeScreen
import com.example.lesson4.presentation.ui.theme.VkClientTheme

class Lesson4Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VkClientTheme {
                Scaffold(
                    topBar = { TopBar() },
                    bottomBar = { BottomBar() },
                ) { paddingValues ->
                    HomeScreen(modifier = Modifier.padding(paddingValues))
                }
            }
        }
    }
}
