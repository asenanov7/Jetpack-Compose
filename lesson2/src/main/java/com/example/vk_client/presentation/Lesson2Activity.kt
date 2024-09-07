package com.example.vk_client.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import com.example.vk_client.presentation.ui.contentCard.PostContentCard
import com.example.vk_client.presentation.ui.main.MainScreen
import com.example.vk_client.presentation.ui.theme.VkClientTheme

internal class Lesson2Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VkClientTheme {
                MainScreen {
                    PostContentCard(modifier = Modifier.padding(it))
                }
            }
        }
    }
}