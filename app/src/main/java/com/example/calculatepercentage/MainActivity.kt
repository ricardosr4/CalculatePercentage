package com.example.calculatepercentage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.calculatepercentage.ui.screen.home.HomeScreen
import com.example.calculatepercentage.ui.theme.CalculatePercentageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatePercentageTheme {
               HomeScreen()
            }
        }
    }
}

