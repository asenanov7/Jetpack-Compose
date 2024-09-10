package com.example.jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpack_compose.ui.theme.JetpackComposeTheme

internal class Lesson1Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            JetpackComposeTheme {

                val vm: InstagramProfileViewModel = viewModel()
                val listProfiles = vm.instagramProfileList.collectAsState()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.background)
                    ) {
                        LazyColumn {

                            items(listProfiles.value, key = { it.id }) { profileInfo ->
                                DismissedProfile(
                                    profileInfo = profileInfo,
                                    dismissThreshold = LocalConfiguration.current.screenWidthDp.dp.value * 0.5f,
                                    onDismissed = { vm.removeProfile(profileInfo) },
                                    onFollowClick = { vm.changeFollowingStatus(profileInfo) }
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun DismissedProfile(
        profileInfo: ProfileInfo,
        dismissThreshold: Float,
        onDismissed: (ProfileInfo) -> Unit,
        onFollowClick: (ProfileInfo) -> Unit,
    ) {
        val dismissState = rememberSwipeToDismissBoxState(
            confirmValueChange = {
                if (it == SwipeToDismissBoxValue.EndToStart) {
                    onDismissed(profileInfo);
                    true
                } else {
                    false
                }
            },
            positionalThreshold = { dismissThreshold }
        )

        SwipeToDismissBox(
            modifier = Modifier.fillMaxWidth(),
            enableDismissFromStartToEnd = false,
            state = dismissState,
            backgroundContent = {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize()
                        .background(Color.Red)
                )
            },
            content = {
                ProfileHeader(profileInfo = profileInfo) {
                    onFollowClick.invoke(profileInfo)
                }
            }
        )
    }

}
