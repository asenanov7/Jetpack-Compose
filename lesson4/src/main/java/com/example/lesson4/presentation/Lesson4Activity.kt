@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.lesson4.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.lesson4.common.TopBar
import com.example.lesson4.common.bottom_bar.BottomBar
import com.example.lesson4.navigation.AppNavGraph
import com.example.lesson4.navigation.Screen
import com.example.lesson4.presentation.screens.HomeScreen
import com.example.lesson4.presentation.ui.theme.VkClientTheme

class Lesson4Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navHostController = rememberNavController()
            VkClientTheme {
                Scaffold(
                    topBar = { TopBar() },
                    bottomBar = { BottomBar(navHostController) },
                ) { paddingValues ->

                    AppNavGraph(
                        navController = navHostController,
                        startDestination = Screen.Home.route,
                        homeScreenContent = { HomeScreen(modifier = Modifier.padding(paddingValues)) },
                        favouriteScreenContent = { Text("Favourite", modifier = Modifier.padding(paddingValues)) },
                        profileScreenContent = { Text("Profile", modifier = Modifier.padding(paddingValues)) }
                    )

                }
            }
        }
    }
}
