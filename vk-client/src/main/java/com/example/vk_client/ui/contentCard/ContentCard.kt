package com.example.vk_client.ui.contentCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vk_client.R
import com.example.vk_client.ui.theme.JetpackComposeTheme

@Composable
@Preview
fun PostContentCard() {
    JetpackComposeTheme {
        Box(
            modifier = Modifier
                //.padding(innerPadding)
                .background(Color.White)
        ) {
            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
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
        Row {
            Image(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp),
                painter = painterResource(R.drawable.post_comunity_thumbnail),
                contentDescription = stringResource(R.string.post_comunity_thumbnail)
            )

            Column(
                modifier = Modifier.padding(start = 12.dp)
            ) {
                Text(text = "уволено", fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "14:00", color = Color.Gray)
            }
        }

        Image(
            modifier = Modifier.clickable { },
            painter = painterResource(id = R.drawable.three_dots_vertical), contentDescription = ""
        )
    }
}

@Preview
@Composable
private fun ContentCard() {
    Text(
        text = "кабаныч, когда узнал, что если сотрудникам не платить они начинают умирать от голода",

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
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("206")
        Image(painter = painterResource(id = R.drawable.ic_views_count), contentDescription = "")
        Text("40")
        Image(painter = painterResource(id = R.drawable.ic_share), contentDescription = "")
        Text(text = "11")
        Image(painter = painterResource(id = R.drawable.ic_comment), contentDescription = "")
        Text(text = "491")
        Image(painter = painterResource(id = R.drawable.ic_like), contentDescription = "")
    }
}

//тень на карточке

