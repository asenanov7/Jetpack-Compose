@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.lesson4.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.lesson4.common.TopBar
import com.example.lesson4.common.bottom_bar.BottomBar
import com.example.lesson4.navigation.AppNavGraph
import com.example.lesson4.navigation.Screen
import com.example.lesson4.navigation.rememberNavigationState
import com.example.lesson4.presentation.ui.screens.HomeScreen
import com.example.lesson4.presentation.ui.screens.commentsScreen.CommentsScreen
import com.example.lesson4.presentation.ui.theme.VkClientTheme

class Lesson4Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VkClientTheme {
                val navigationState = rememberNavigationState()

                Scaffold(
                    topBar = { TopBar(navigationState) },
                    bottomBar = { BottomBar(navigationState) },
                ) { paddingValues ->

                    AppNavGraph(
                        navController = navigationState.navHostController,
                        startDestination = Screen.Home.route,
                        homeScreenContent = { HomeScreen(modifier = Modifier.padding(paddingValues), navigationState = navigationState) },
                        favouriteScreenContent = { TestCounter("Favourite", paddingValues) },
                        profileScreenContent = { TestCounter("Profile", paddingValues) },
                        commentsScreenContent = { CommentsScreen(modifier = Modifier.padding(paddingValues)) }
                    )

                }
            }
        }
    }
}

@Composable
private fun TestCounter(name: String, paddingValues: PaddingValues) {
    var count by rememberSaveable { mutableIntStateOf(0) }

    Text("$name $count", modifier = Modifier
        .padding(paddingValues)
        .clickable { count++ })
}