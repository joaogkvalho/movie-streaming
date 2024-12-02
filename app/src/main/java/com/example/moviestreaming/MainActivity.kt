package com.example.moviestreaming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.moviestreaming.presenter.screens.splash.SplashScreen
import com.example.moviestreaming.presenter.screens.welcome.WelcomeScreen
import com.example.moviestreaming.presenter.theme.MovieStreamingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieStreamingTheme {
                WelcomeScreen()
            }
        }
    }
}