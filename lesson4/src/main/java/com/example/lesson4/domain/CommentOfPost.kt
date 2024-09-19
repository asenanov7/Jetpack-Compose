package com.example.lesson4.domain

data class CommentOfPost(
    val id: Int,
    val post: PostInfoItem,
    val author: Author,
    val text: String,
    val time: String,
)