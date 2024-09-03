package com.example.jetpack_compose.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.jetpack_compose.ui.theme.JetpackComposeTheme

@Preview
@Composable
fun ProfileHeaderDark() {
    JetpackComposeTheme(darkTheme = true) {
        HeaderCard {
            TopUpInfo()
            BottomUpInfo()
        }
    }
}

@Preview
@Composable
fun ProfileHeaderLight() {
    JetpackComposeTheme(darkTheme = false) {
        HeaderCard {
            TopUpInfo()
            BottomUpInfo()
        }
    }
}

@Composable
private fun HeaderCard(cardContent: @Composable () -> Unit) {
    Card(
        shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground
        ),
        border = BorderStroke(0.8.dp, MaterialTheme.colorScheme.onBackground),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp)
    ) {
        cardContent()
    }
}

@Composable
private fun TopUpInfo() {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.icons_instagram),
            contentDescription = stringResource(R.string.instagram_logo),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(54.dp)
                .background(if (isSystemInDarkTheme()) Color.Transparent else Color.White)

        )

        InformationColumn(nameOfColumn = "Posts", count = "6,950")
        InformationColumn(nameOfColumn = "Followers", count = "436M")
        InformationColumn(nameOfColumn = "Following", count = "76")

    }
}

@Composable
private fun InformationColumn(nameOfColumn: String, count: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        Text(
            text = count,
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
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onBackground,
                    contentColor = MaterialTheme.colorScheme.background
                )
            ) {
                Text(text = "Follow")
            }

        }
    }
}
