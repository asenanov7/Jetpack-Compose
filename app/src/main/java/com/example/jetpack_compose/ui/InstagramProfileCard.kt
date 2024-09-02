package com.example.jetpack_compose.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_compose.R

@Preview
@Composable
fun ProfileHeader() {
    HeaderCard {
        TopUpInfo()
        BottomUpInfo()
    }
}

@Composable
private fun HeaderCard(cardContent: @Composable () -> Unit) {
    Card(
        shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
        colors = CardColors(Color.White, Color.Black, Color.LightGray, Color.DarkGray),
        border = BorderStroke(0.8.dp, Color.Black),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        cardContent()
    }
}

@Composable
private fun TopUpInfo() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
    ) {
        Image(
            painterResource(R.drawable.icons_instagram),
            contentDescription = stringResource(R.string.instagram_logo),
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(54.dp)
        )

        InformationColumn(nameOfColumn = "Posts", count = 6950)
        InformationColumn(nameOfColumn = "Followers", count = 436)
        InformationColumn(nameOfColumn = "Following", count = 76)

    }
}

@Composable
private fun InformationColumn(nameOfColumn: String, count: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        Text(
            text = count.toString(),
            fontFamily = FontFamily.Cursive,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 38.sp,
        )
        Text(
            text = nameOfColumn,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 14.sp,
        )
    }
}

@Composable
private fun BottomUpInfo() {
    Box(modifier = Modifier.padding(start = 8.dp, top = 8.dp, bottom = 4.dp)) {
        Column {
            Text(
                fontFamily = FontFamily.Cursive,
                text = stringResource(R.string.instagram),
                fontSize = 32.sp
            )
            Text(text = stringResource(R.string.yourstomake))
            Text(text = stringResource(R.string.www_facebook_com_emotional_health))

            Spacer(modifier = Modifier.padding(top = 8.dp))

            Button(
                onClick = { TODO() },
                shape = RectangleShape,
            ) {
                Text(
                    text = "Follow",
                    color = Color.Black,
                )
            }

        }
    }
}
