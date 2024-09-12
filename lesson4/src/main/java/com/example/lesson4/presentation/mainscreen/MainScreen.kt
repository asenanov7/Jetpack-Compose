package com.example.lesson4.presentation.mainscreen

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lesson4.data.VkPostViewModel
import com.example.lesson4.presentation.vk_post.VkPostContentCard
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalFoundationApi::class)
@ExperimentalMaterial3Api
@Composable
fun MainScreen(viewModel: VkPostViewModel = viewModel()) {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() },
    ) { paddingValues ->

        val vkPosts = viewModel.vkPosts.collectAsState()

        LaunchedEffect(key1 = 1) {
            viewModel.vkPosts.collectLatest {
                Log.d("ARSEN", "$it")
            }
        }

        LazyColumn(modifier = Modifier.padding(paddingValues)) {
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
}