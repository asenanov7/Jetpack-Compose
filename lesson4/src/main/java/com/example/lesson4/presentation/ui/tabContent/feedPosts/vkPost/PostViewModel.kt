package com.example.lesson4.presentation.ui.tabContent.feedPosts.vkPost

import androidx.lifecycle.ViewModel
import com.example.lesson4.R
import com.example.lesson4.domain.Author
import com.example.lesson4.domain.HomeState
import com.example.lesson4.domain.Post
import com.example.lesson4.domain.PostInfoItem
import com.example.lesson4.domain.StatisticItem
import com.example.lesson4.domain.StatisticType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class VkPostViewModel : ViewModel() {

    private val listOfPosts = mutableListOf<PostInfoItem>().apply {
        repeat(10) {
            add(
                PostInfoItem(
                    id = it,
                    author = Author("Автор: $it ", R.drawable.post_comunity_thumbnail),
                    time = System.currentTimeMillis(),
                    post = Post(
                        text = "$it, кабаныч, когда узнал, что если сотрудникам не платить они начинают умирать от голода",
                        postResId = R.drawable.post_content_image
                    ),
                    statisticItems = listOf(
                        StatisticItem(R.drawable.ic_views_count, it, StatisticType.VIEW),
                        StatisticItem(R.drawable.ic_share, it, StatisticType.SHARE),
                        StatisticItem(R.drawable.ic_comment, it, StatisticType.COMMENT),
                        StatisticItem(R.drawable.ic_like, it, StatisticType.LIKE),
                    )
                )
            )
        }
    }

    private val _screenState = MutableStateFlow(HomeState.FeedPost(listOfPosts))

    val screenState: StateFlow<HomeState> = _screenState.asStateFlow()

    fun updateCount(postInfoItem: PostInfoItem, clickedItem: StatisticItem) {
        if (screenState.value !is HomeState.FeedPost) return
        val newStatistics = postInfoItem.statisticItems.toMutableList().apply {
            replaceAll { item ->
                if (item == clickedItem) item.copy(count = item.count.plus(1))
                else item
            }
        }
        val updatedItem =
            _screenState.value.posts.find { it == postInfoItem }?.copy(statisticItems = newStatistics)
                ?: throw IllegalArgumentException("post is not find")

        val newCollection = _screenState.value.posts.toMutableList().apply {
            replaceAll {
                if (it.id == updatedItem.id) {
                    it.copy(statisticItems = newStatistics)
                } else {
                    it
                }
            }
        }
        _screenState.value = HomeState.FeedPost(newCollection)
    }

    fun removePost(postInfoItem: PostInfoItem) {
        if (screenState.value !is HomeState.FeedPost) return
        val newCollection = _screenState.value.posts.toMutableList().apply { remove(postInfoItem) }
        _screenState.value = HomeState.FeedPost(newCollection)
    }

}