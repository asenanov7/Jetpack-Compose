package com.example.vk_client.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vk_client.data.PostViewModel
import com.example.vk_client.domain.StatisticType
import com.example.vk_client.presentation.ui.contentCard.PostContentCard
import com.example.vk_client.presentation.ui.main.MainScreen
import com.example.vk_client.presentation.ui.theme.VkClientTheme

internal class Lesson2Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VkClientTheme {
                MainScreen {
                    val viewModel: PostViewModel = viewModel()
                    val state = viewModel.postInfo.collectAsState()

                    PostContentCard(modifier = Modifier.padding(it), postInfoItem = state.value) { newItem ->
                        when (newItem.type) {
                            StatisticType.LIKE -> viewModel.changeStatistics(newItem)
                            StatisticType.VIEW -> viewModel.changeStatistics(newItem)
                            StatisticType.SHARE -> viewModel.changeStatistics(newItem)
                            StatisticType.COMMENT -> viewModel.changeStatistics(newItem)
                        }
                    }
                }
            }
        }
    }
}