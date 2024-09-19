package com.example.lesson4.presentation.ui.tabContent.commentsScreen

import androidx.lifecycle.ViewModel
import com.example.lesson4.R
import com.example.lesson4.domain.Author
import com.example.lesson4.domain.CommentOfPost
import com.example.lesson4.domain.Post
import com.example.lesson4.domain.PostInfoItem
import com.example.lesson4.domain.StatisticItem
import com.example.lesson4.domain.StatisticType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CommentsViewModel : ViewModel() {

    private val mockPost = PostInfoItem(
        id = 1,
        author = Author("Автор: $1 ", R.drawable.post_comunity_thumbnail),
        time = System.currentTimeMillis(),
        post = Post(
            text = "$1, кабаныч, когда узнал, что если сотрудникам не платить они начинают умирать от голода",
            postResId = R.drawable.post_content_image
        ),
        statisticItems = listOf(
            StatisticItem(R.drawable.ic_views_count, 1, StatisticType.VIEW),
            StatisticItem(R.drawable.ic_share, 1, StatisticType.SHARE),
            StatisticItem(R.drawable.ic_comment, 1, StatisticType.COMMENT),
            StatisticItem(R.drawable.ic_like, 1, StatisticType.LIKE),
        )
    )

    private val mockComments = mutableListOf<CommentOfPost>().apply {
        repeat(10) {
            add(
                CommentOfPost(
                    id = it,
                    post = mockPost,
                    author = Author("Name: $it", R.drawable.post_comunity_thumbnail),
                    text = "text $it",
                    time = "14:00"
                )
            )
        }
    }

    private val _stateFlowComment = MutableStateFlow(mockComments)
    val stateFlowComment = _stateFlowComment.asStateFlow()

}