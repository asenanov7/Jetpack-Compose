package com.example.jetpack_compose

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class InstagramProfileViewModel : ViewModel() {

    private val initialList = listOf(
        ProfileInfo(1, "Title1", false),
        ProfileInfo(2, "Title2", false),
        ProfileInfo(3, "Title3", false),
        ProfileInfo(4, "Title4", false),
        ProfileInfo(5, "Title5", false),
        ProfileInfo(6, "Title6", false),
        ProfileInfo(7, "Title7", false),
        ProfileInfo(8, "Title8", false),
        ProfileInfo(9, "Title9", false),
    )

    private val _instagramProfileList = MutableStateFlow(initialList)
    val instagramProfileList: StateFlow<List<ProfileInfo>> = _instagramProfileList.asStateFlow()

    fun changeFollowingStatus(profileInfo: ProfileInfo) {
        Log.d("ARSEN", "changeFollowingStatus: ${profileInfo.id}")

        val updatedList = _instagramProfileList.value.toMutableList().apply {
            replaceAll {
                if (it.id == profileInfo.id) {
                    it.copy(isFollowing = profileInfo.isFollowing.not())
                } else {
                    it
                }
            }
        }
        _instagramProfileList.value = updatedList
    }
}