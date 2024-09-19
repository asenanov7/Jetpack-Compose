package com.example.lesson4.presentation.ui.tabContent.commentsScreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lesson4.presentation.ui.tabContent.commentsScreen.comment.Comment

@Preview
@Composable
fun CommentsScreen(
    paddingValues: PaddingValues = PaddingValues(),
    vm: CommentsViewModel = viewModel(),
) {

    val stateOfComments = vm.stateFlowComment.collectAsState()

    LazyColumn(modifier = Modifier.padding(paddingValues)) {
        items(stateOfComments.value, key = { it.id }) { userComment ->
            Comment(comment = userComment)
        }
    }

}
