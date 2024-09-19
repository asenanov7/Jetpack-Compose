@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)

package com.example.lesson4.presentation.ui.tabContent.feedPosts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lesson4.domain.PostInfoItem
import com.example.lesson4.presentation.ui.tabContent.feedPosts.vkPost.VkPostCard
import com.example.lesson4.presentation.ui.tabContent.feedPosts.vkPost.VkPostViewModel

@Composable
fun FeedPostsScreen(
    paddingValues: PaddingValues,
    vkPosts: List<PostInfoItem>,
    viewModel: VkPostViewModel = viewModel(),
) {
    LazyColumn(modifier = Modifier.padding(paddingValues)) {
        items(vkPosts, key = { it.id }) { postInfo ->
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
                VkPostCard(
                    postInfoItem = postInfo,
                    onViewClick = { clickedStatistic -> viewModel.updateCount(postInfo, clickedStatistic) },
                    onShareClick = { clickedStatistic -> viewModel.updateCount(postInfo, clickedStatistic) },
                    onCommentClick = { viewModel.showComments(postInfo) },
                    onLikeClick = { clickedStatistic -> viewModel.updateCount(postInfo, clickedStatistic) },
                )
            }
        }
    }
}