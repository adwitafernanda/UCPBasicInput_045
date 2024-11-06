package com.example.latihanucp1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.latihanucp1.ui.theme.Latihanucp1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Latihanucp1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BiodataFormScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

