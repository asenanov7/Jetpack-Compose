package com.example.lesson4.presentation.ui.tabs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lesson4.domain.HomeState
import com.example.lesson4.presentation.ui.tabContent.commentsScreen.CommentsScreen
import com.example.lesson4.presentation.ui.tabContent.feedPosts.FeedPostsScreen
import com.example.lesson4.presentation.ui.tabContent.feedPosts.vkPost.VkPostViewModel

@ExperimentalMaterial3Api
@Composable
fun HomeTab(paddingValues: PaddingValues, viewModel: VkPostViewModel = viewModel()) {
    val state = viewModel.screenState.collectAsState()

    when (val currentState = state.value) {
        is HomeState.FeedPost -> {
            FeedPostsScreen(vkPosts = currentState.posts, paddingValues = paddingValues)
        }
        is HomeState.PostComments -> {
            CommentsScreen(comments = currentState.comments, paddingValues = paddingValues)
        }
        is HomeState.Initial -> {
            Unit
        }
    }

}