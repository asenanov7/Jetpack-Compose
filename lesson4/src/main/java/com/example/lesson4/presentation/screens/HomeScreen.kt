package com.example.lesson4.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lesson4.presentation.ui.vk_post.VkPostViewModel
import com.example.lesson4.presentation.ui.vk_post.VkPostContentCard

@OptIn(ExperimentalFoundationApi::class)
@ExperimentalMaterial3Api
@Composable
fun HomeScreen(modifier: Modifier, viewModel: VkPostViewModel = viewModel()) {
    val vkPosts = viewModel.vkPosts.collectAsState()

    LazyColumn(modifier = modifier) {
        items(vkPosts.value, key = { it.id }) { postInfo ->
            val swipeState = rememberSwipeToDismissBoxState(
                confirmValueChange = { swipedValue ->
                    if (SwipeToDismissBoxValue.EndToStart == swipedValue) {
                        viewModel.removePost(postInfo)
                    }
                    true
                }
            )

            SwipeToDismissBox(
                modifier = Modifier.animateItemPlacement(),
                state = swipeState,
                backgroundContent = {},
                enableDismissFromStartToEnd = false
            ) {
                VkPostContentCard(
                    postInfoItem = postInfo,
                    onViewClick = { clickedStatistic -> viewModel.updateCount(postInfo, clickedStatistic) },
                    onShareClick = { clickedStatistic -> viewModel.updateCount(postInfo, clickedStatistic) },
                    onCommentClick = { clickedStatistic -> viewModel.updateCount(postInfo, clickedStatistic) },
                    onLikeClick = { clickedStatistic -> viewModel.updateCount(postInfo, clickedStatistic) },
                )
            }
        }
    }
}