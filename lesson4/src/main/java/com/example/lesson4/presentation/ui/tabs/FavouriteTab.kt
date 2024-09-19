package com.example.lesson4.presentation.ui.tabs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
private fun FavouriteTab(paddingValues: PaddingValues) {
    var count by rememberSaveable { mutableIntStateOf(0) }

    Text("Favourite $count", modifier = Modifier
        .padding(paddingValues)
        .clickable { count++ })
}