package com.example.vk_client.data

import androidx.lifecycle.ViewModel
import com.example.vk_client.R
import com.example.vk_client.domain.Author
import com.example.vk_client.domain.Post
import com.example.vk_client.domain.PostInfoItem
import com.example.vk_client.domain.StatisticItem
import com.example.vk_client.domain.StatisticType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PostViewModel : ViewModel() {

    private val _postInfo = MutableStateFlow(
        PostInfoItem(
            author = Author("Уволено", R.drawable.post_comunity_thumbnail),
            time = System.currentTimeMillis(),
            post = Post(
                text = "кабаныч, когда узнал, что если сотрудникам не платить они начинают умирать от голода",
                postResId = R.drawable.post_content_image
            ),
            statisticItems = listOf(
                StatisticItem(type = StatisticType.VIEW, 916),
                StatisticItem(type = StatisticType.SHARE, 7),
                StatisticItem(type = StatisticType.COMMENT, 8),
                StatisticItem(type = StatisticType.LIKE, 23),
            )
        )
    )

    val postInfo: StateFlow<PostInfoItem> = _postInfo.asStateFlow()

    fun changeStatistics(newItem: StatisticItem) {
        val newList = _postInfo.value.statisticItems.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == newItem.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }
        _postInfo.value = _postInfo.value.copy(statisticItems = newList)
    }

}