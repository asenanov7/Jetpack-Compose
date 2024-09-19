package com.example.lesson4.presentation.ui.tabs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lesson4.presentation.ui.tabContent.feedPosts.FeedPostsScreen
import com.example.lesson4.presentation.ui.tabContent.feedPosts.vkPost.VkPostViewModel

@ExperimentalMaterial3Api
@Composable
fun HomeTab(paddingValues: PaddingValues, viewModel: VkPostViewModel = viewModel()) {
    val vkPosts = viewModel.vkPosts.collectAsState()

    FeedPostsScreen(vkPosts = vkPosts.value, paddingValues = paddingValues)
}