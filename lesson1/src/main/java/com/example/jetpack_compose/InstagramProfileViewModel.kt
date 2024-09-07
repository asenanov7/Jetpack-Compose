package com.example.jetpack_compose

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class InstagramProfileViewModel : ViewModel() {

    private val _isFollowing = MutableStateFlow(false)
    val isFollowing: StateFlow<Boolean> = _isFollowing.asStateFlow()

    fun changeFollowingStatus() {
        val wasFollowing = _isFollowing.value
        _isFollowing.value = wasFollowing.not()
    }
}