package com.example.lesson4.presentation.mainscreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lesson4.data.VkPostViewModel
import com.example.lesson4.presentation.vk_post.VkPostContentCard

@ExperimentalMaterial3Api
@Composable
fun MainScreen(viewModel: VkPostViewModel = viewModel()) {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() },
    ) { paddingValues ->

        val postInfoState = viewModel.postInfoState.collectAsState()
        VkPostContentCard(
            modifier = Modifier.padding(paddingValues),
            postInfoItem = postInfoState,
            onViewClick = { viewModel.updateCount(it) },
            onShareClick = { viewModel.updateCount(it) },
            onCommentClick = { viewModel.updateCount(it) },
            onLikeClick = { viewModel.updateCount(it) },
        )

    }
}