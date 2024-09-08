package com.example.lesson4.domain

data class PostInfoItem(
    val author: Author,
    val post: Post,
    val statisticItems: List<StatisticItem>,
    val time: Long,
)

data class Author(
    val name: String,
    val avatarResId: Int,
)

data class Post(
    val text: String,
    val postResId: Int,
)

data class StatisticItem(
    val iconResId: Int, //url
    val count: Int,
    val type: StatisticType,
)

enum class StatisticType {
    VIEW, LIKE, COMMENT, SHARE
}

