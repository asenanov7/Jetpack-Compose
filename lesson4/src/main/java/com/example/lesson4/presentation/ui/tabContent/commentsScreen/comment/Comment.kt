package com.example.lesson4.presentation.ui.tabContent.commentsScreen.comment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.lesson4.domain.CommentOfPost

@Composable
fun Comment(modifier: Modifier = Modifier, comment: CommentOfPost) {
    Column(
        modifier
            .padding(horizontal = 14.dp, vertical = 8.dp)
    ) {
        Row {
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                painter = painterResource(comment.author.avatarResId),
                contentDescription = null
            )

            Spacer(modifier = Modifier.padding(horizontal = 4.dp))

            Column {
                Text(text = comment.author.name)
                Text(text = comment.text)
                Text(text = comment.time)
            }
        }

    }
}