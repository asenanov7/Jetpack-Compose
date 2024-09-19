package com.example.lesson4.presentation.ui.tabContent.feedPosts.vkPost

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lesson4.domain.PostInfoItem
import com.example.lesson4.domain.StatisticItem

@Composable
internal fun VkPostCard(
    modifier: Modifier = Modifier,
    postInfoItem: PostInfoItem,
    onViewClick: (StatisticItem) -> Unit,
    onShareClick: (StatisticItem) -> Unit,
    onCommentClick: (StatisticItem) -> Unit,
    onLikeClick: (StatisticItem) -> Unit,
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
        shape = RoundedCornerShape(4.dp),
        modifier = modifier.padding(5.dp)
    ) {
        Column(modifier = Modifier.padding(4.dp)) {
            PostHeader(postInfoItem)
            Spacer(modifier = Modifier.height(8.dp))
            PostContent(postInfoItem)
            Spacer(modifier = Modifier.height(8.dp))
            PostStatisticPanel(
                statistics = postInfoItem.statisticItems,
                onViewClick = { onViewClick.invoke(it) },
                onShareClick = { onShareClick.invoke(it) },
                onLikeClick = { onLikeClick.invoke(it) },
                onCommentClick = { onCommentClick.invoke(it) },
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
