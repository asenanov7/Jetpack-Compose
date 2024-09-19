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
import com.example.lesson4.common.topBar.TopBar
import com.example.lesson4.common.bottomBar.BottomBar
import com.example.lesson4.navigation.AppNavGraph
import com.example.lesson4.navigation.Tabs
import com.example.lesson4.navigation.rememberNavigationState
import com.example.lesson4.presentation.ui.tabs.HomeTab
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
                        startDestination = Tabs.Home.route,
                        homeTabContent = { HomeTab(paddingValues = paddingValues) },
                        favouriteTabContent = { TestCounter("Favourite", paddingValues) },
                        profileTabContent = { TestCounter("Profile", paddingValues) },
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