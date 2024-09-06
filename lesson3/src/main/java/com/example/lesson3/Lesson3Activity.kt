package com.example.lesson3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Lesson3Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlertDialogSample()
        }
    }

    @Preview
    @Composable
    fun OutlinedButtonSample() {
        OutlinedButton(shape = RoundedCornerShape(size = 4.dp), onClick = { /* Do something! */ }) { Text("Outlined Button") }
    }

    @Preview
    @Composable
    fun InputLayout() {
        val text = rememberSaveable { mutableStateOf("") }

        TextField(
            value = text.value,
            onValueChange = { text.value = it },
            label = { Text(text = "asd") }

        )
    }

    @Preview
    @Composable
    fun AlertDialogSample() {
        AlertDialog(
            title = { Text(text = "Are you sure?", fontSize = 14.sp) },
            text = { Text(text = "Do you want to delete this file?") },
            onDismissRequest = { /*TODO*/ },
            confirmButton = { Text(text = "Yes", Modifier.padding(8.dp)) },
            dismissButton = { Text(text = "No", Modifier.padding(8.dp)) }
        )
    }
}
