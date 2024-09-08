package com.example.lesson4.data

import androidx.lifecycle.ViewModel
import com.example.lesson4.R
import com.example.lesson4.domain.Author
import com.example.lesson4.domain.Post
import com.example.lesson4.domain.PostInfoItem
import com.example.lesson4.domain.StatisticItem
import com.example.lesson4.domain.StatisticType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class VkPostViewModel : ViewModel() {

    private val _postInfoState = MutableStateFlow(
        PostInfoItem(
            author = Author("Уволено", R.drawable.post_comunity_thumbnail),
            time = System.currentTimeMillis(),
            post = Post(
                text = "кабаныч, когда узнал, что если сотрудникам не платить они начинают умирать от голода",
                postResId = R.drawable.post_content_image
            ),
            statisticItems = listOf(
                StatisticItem(R.drawable.ic_views_count, 990, StatisticType.VIEW),
                StatisticItem(R.drawable.ic_share, 60, StatisticType.SHARE),
                StatisticItem(R.drawable.ic_comment, 23, StatisticType.COMMENT),
                StatisticItem(R.drawable.ic_like, 244, StatisticType.LIKE),
            )
        )
    )

    val postInfoState: StateFlow<PostInfoItem> = _postInfoState.asStateFlow()

    fun updateCount(clickedItem: StatisticItem) {
        val newStatistics = _postInfoState.value.statisticItems.toMutableList().apply {
            replaceAll { item ->
                if (item == clickedItem) item.copy(count = item.count.plus(1))
                else item
            }
        }
        _postInfoState.value = _postInfoState.value.copy(statisticItems = newStatistics)
    }

}