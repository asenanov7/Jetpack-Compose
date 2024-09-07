package com.example.vk_client.domain

data class StatisticItem(
    val type: StatisticType,
    val count: Int
)

enum class StatisticType{
    VIEW, SHARE, COMMENT, LIKE
}