package com.example.lesson4.presentation.vk_post

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.lesson4.R
import com.example.lesson4.domain.StatisticItem
import com.example.lesson4.domain.StatisticType
import com.example.lesson4.domain.StatisticType.COMMENT
import com.example.lesson4.domain.StatisticType.LIKE
import com.example.lesson4.domain.StatisticType.SHARE
import com.example.lesson4.domain.StatisticType.VIEW

@Composable
fun StatisticPanel(
    statistics: List<StatisticItem>,
    onViewClick: (StatisticItem) -> Unit,
    onShareClick: (StatisticItem) -> Unit,
    onCommentClick: (StatisticItem) -> Unit,
    onLikeClick: (StatisticItem) -> Unit,
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Row(modifier = Modifier.weight(1f)) {
            val viewStatisticItem = statistics.getStatisticItemWithType(VIEW)
            Statistic(
                statisticItem = viewStatisticItem,
                contentDescription = stringResource(R.string.viewers_statistic)
            ) {
                onViewClick(viewStatisticItem)
            }
        }

        Row {
            val shareStatisticItem = statistics.getStatisticItemWithType(SHARE)
            Statistic(
                statisticItem = shareStatisticItem,
                contentDescription = stringResource(R.string.viewers_statistic)
            ) {
                onShareClick(shareStatisticItem)
            }

            val commentStatisticItem = statistics.getStatisticItemWithType(COMMENT)
            Statistic(
                statisticItem = commentStatisticItem,
                contentDescription = stringResource(R.string.viewers_statistic)
            ) {
                onCommentClick(commentStatisticItem)
            }

            val likeStatisticItem = statistics.getStatisticItemWithType(LIKE)
            Statistic(
                statisticItem = likeStatisticItem,
                contentDescription = stringResource(R.string.viewers_statistic)
            ) {
                onLikeClick(likeStatisticItem)
            }
        }

    }
}

@Composable
private fun Statistic(statisticItem: StatisticItem, contentDescription: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Icon(
            painter = painterResource(id = statisticItem.iconResId),
            contentDescription = contentDescription,
            tint = MaterialTheme.colorScheme.onSecondary
        )
        Spacer(Modifier.width(4.dp))
        Text(text = statisticItem.count.toString(), color = MaterialTheme.colorScheme.onSecondary)
    }

}

private fun List<StatisticItem>.getStatisticItemWithType(type: StatisticType): StatisticItem =
    find { it.type == type } ?: throw IllegalArgumentException("Type $type not find")


