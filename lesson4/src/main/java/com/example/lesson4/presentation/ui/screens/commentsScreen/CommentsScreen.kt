package com.example.lesson4.presentation.ui.screens.commentsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lesson4.domain.UserComment

@Preview
@Composable
fun CommentsScreen(vm: CommentsViewModel = viewModel(), modifier: Modifier = Modifier) {

    val stateOfComments = vm.stateFlowComment.collectAsState()

    LazyColumn(modifier) {
        items(stateOfComments.value, key = { it.id }) { userComment ->
            Comment(userComment = userComment)
        }
    }

}

@Preview
@Composable
private fun Comment(modifier: Modifier = Modifier, userComment: UserComment) {
    Column(
        modifier
            .padding(horizontal = 14.dp, vertical = 8.dp)
    ) {
        Row {
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                painter = painterResource(userComment.author.avatarResId),
                contentDescription = null
            )

            Spacer(modifier = Modifier.padding(horizontal = 4.dp))

            Column {
                Text(text = userComment.author.name)
                Text(text = userComment.text)
                Text(text = userComment.time)
            }
        }

    }
}