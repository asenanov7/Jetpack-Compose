package com.example.lesson4.domain

data class UserComment(
    val id: Int,
    val author: Author,
    val text: String,
    val time: String,
)