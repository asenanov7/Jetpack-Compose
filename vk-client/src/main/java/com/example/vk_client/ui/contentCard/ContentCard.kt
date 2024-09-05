package com.example.vk_client.ui.contentCard

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
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.vk_client.R

@Composable
@PreviewLightDark
fun PostContentCard() {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onBackground
        ),
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .padding(5.dp)

    ) {
        Column(modifier = Modifier.padding(4.dp)) {
            HeaderCard()
            Spacer(modifier = Modifier.height(8.dp))
            ContentCard()
            Spacer(modifier = Modifier.height(8.dp))
            FooterCard()
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
            Text(text = "уволено", fontWeight = FontWeight.Medium, color = MaterialTheme.colorScheme.primary)
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
        color = MaterialTheme.colorScheme.primary
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
private fun FooterCard() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BottomItem(R.drawable.ic_views_count, "916", Modifier.weight(0.6f))
        BottomItem(R.drawable.ic_share, "7", Modifier.weight(0.1f))
        BottomItem(R.drawable.ic_comment, "8", Modifier.weight(0.1f))
        BottomItem(R.drawable.ic_like, "23", Modifier.weight(0.1f))

    }
}

@Composable
private fun BottomItem(resourceId: Int, text: String, modifier: Modifier, contentDesc: String? = null) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = resourceId),
            contentDescription = contentDesc,
            tint = MaterialTheme.colorScheme.onSecondary
        )
        Spacer(Modifier.width(4.dp))
        Text(text = text, color = MaterialTheme.colorScheme.onSecondary)
    }
}

//тень на карточке

