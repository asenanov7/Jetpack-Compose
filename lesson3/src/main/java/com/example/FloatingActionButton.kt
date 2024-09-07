package com.example

import android.util.Log
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.example.bottom_navigation_bar.BottomNavigationBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Preview
@Composable
fun Test() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val fabIsVisible = remember { mutableStateOf(true) }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        floatingActionButton = { MyFloatingActionButton(snackbarHostState, scope, fabIsVisible) },
        bottomBar = { BottomNavigationBar() }) {
    }


}

@Composable
fun MyFloatingActionButton(snackbarHostState: SnackbarHostState, scope: CoroutineScope, fabIsVisible: MutableState<Boolean>) {
    if (fabIsVisible.value) {
        FloatingActionButton(
            shape = CircleShape,
            onClick = {
                scope.launch {
                    val snackbarResult = snackbarHostState.showSnackbar(
                        message = "This is your message",
                        actionLabel = "Do something."
                    )
                    when (snackbarResult) {
                        SnackbarResult.Dismissed -> Log.d("SnackbarDemo", "Dismissed")
                        SnackbarResult.ActionPerformed -> fabIsVisible.value = false
                    }
                }
            },
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
        }
    }
}
