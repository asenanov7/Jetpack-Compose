@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.lesson4.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.lesson4.presentation.mainscreen.MainScreen
import com.example.lesson4.presentation.ui.theme.VkClientTheme

class Lesson4Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VkClientTheme {
                MainScreen()
            }
        }
    }
}
