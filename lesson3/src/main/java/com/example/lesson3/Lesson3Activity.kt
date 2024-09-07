package com.example.lesson3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.lesson3.scaffold.MyScaffold
import com.example.lesson3.ui.theme.JetpackComposeTheme

class Lesson3Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTheme {
                MyScaffold()
            }
        }
    }
}
