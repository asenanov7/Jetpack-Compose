package com.example.lesson4.presentation.ui.tabContent.commentsScreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lesson4.domain.CommentOfPost
import com.example.lesson4.presentation.ui.tabContent.commentsScreen.comment.Comment

@Preview
@Composable
fun CommentsScreen(
    paddingValues: PaddingValues = PaddingValues(),
    comments: List<CommentOfPost>,
) {

    LazyColumn(modifier = Modifier.padding(paddingValues)) {
        items(comments, key = { it.id }) { userComment ->
            Comment(comment = userComment)
        }
    }

}
