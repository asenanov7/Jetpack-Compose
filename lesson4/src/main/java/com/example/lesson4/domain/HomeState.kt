package com.example.lesson4.domain

sealed class HomeState {

    data object Initial : HomeState()

    data class FeedPost(val posts: List<PostInfoItem>) : HomeState()

    data class PostComments(val comments: List<CommentOfPost>) : HomeState()

}
