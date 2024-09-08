package com.example.vk_client.domain

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

data class StatisticItem(
    val type: StatisticType,
    val count: Int,
)

data class Post(
    val text: String,
    val postResId: Int,
)

enum class StatisticType {
    VIEW, SHARE, COMMENT, LIKE
}

