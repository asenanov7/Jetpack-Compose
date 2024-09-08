package com.example.vk_client.presentation.ui.contentCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vk_client.R
import com.example.vk_client.domain.StatisticItem
import com.example.vk_client.domain.StatisticType

@Composable
internal fun PostContentCard(modifier: Modifier = Modifier) {

    val mockStatisticItemList = listOf(
        StatisticItem(type = StatisticType.VIEW, 916),
        StatisticItem(type = StatisticType.SHARE, 7),
        StatisticItem(type = StatisticType.COMMENT, 8),
        StatisticItem(type = StatisticType.LIKE, 23),
    )

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        shape = RoundedCornerShape(4.dp),
        modifier = modifier.padding(5.dp)

    ) {
        Column(modifier = Modifier.padding(4.dp)) {
            HeaderCard()
            Spacer(modifier = Modifier.height(8.dp))
            ContentCard()
            Spacer(modifier = Modifier.height(8.dp))
            Statistics(mockStatisticItemList)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview
@Composable
private fun HeaderCard() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier
                .clip(CircleShape)
                .size(50.dp),
            painter = painterResource(R.drawable.post_comunity_thumbnail),
            contentDescription = stringResource(R.string.post_comunity_thumbnail)
        )

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(start = 8.dp)
                .height(50.dp)
                .weight(1f)
        ) {
            Text(text = "уволено", fontWeight = FontWeight.Medium, color = MaterialTheme.colorScheme.onBackground)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "14:00", color = MaterialTheme.colorScheme.onSecondary)
        }

        Icon(
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary
        )
    }
}

@Preview
@Composable
private fun ContentCard() {
    Text(
        text = "кабаныч, когда узнал, что если сотрудникам не платить они начинают умирать от голода",
        color = MaterialTheme.colorScheme.onBackground
    )
    Spacer(modifier = Modifier.height(8.dp))
    Image(
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth,
        painter = painterResource(id = R.drawable.post_content_image),
        contentDescription = ""
    )
}

@Preview
@Composable
private fun Statistics(
    statistics: List<StatisticItem>,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        statistics.forEach { StatisticItem(statisticItem = it) }
    }
}

@Composable
private fun StatisticItem(statisticItem: StatisticItem) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = getIconId(statisticItem.type)),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary
        )
        Spacer(Modifier.width(4.dp))
        Text(text = statisticItem.count.toString(), color = MaterialTheme.colorScheme.onSecondary)
    }

}

private fun getIconId(statisticType: StatisticType) = when (statisticType) {
    StatisticType.VIEW -> R.drawable.ic_views_count
    StatisticType.SHARE -> R.drawable.ic_share
    StatisticType.COMMENT -> R.drawable.ic_comment
    StatisticType.LIKE -> R.drawable.ic_like
}

