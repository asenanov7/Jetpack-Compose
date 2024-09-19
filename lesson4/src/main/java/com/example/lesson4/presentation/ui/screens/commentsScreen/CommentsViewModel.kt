package com.example.lesson4.presentation.ui.screens.commentsScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.lesson4.R
import com.example.lesson4.domain.Author
import com.example.lesson4.domain.UserComment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CommentsViewModel : ViewModel() {

    private val comments = mutableListOf<UserComment>().apply {
        repeat(10){
            add(UserComment(
                id = it,
                author = Author("Name: $it", R.drawable.post_comunity_thumbnail),
                text = "text $it",
                time = "14:00"
            ))
        }
    }

    private val _stateFlowComment = MutableStateFlow(comments)
    val stateFlowComment = _stateFlowComment.asStateFlow()


}