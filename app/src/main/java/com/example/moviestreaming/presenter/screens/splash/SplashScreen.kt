package com.example.moviestreaming.presenter.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.moviestreaming.R
import com.example.moviestreaming.presenter.theme.MovieStreamingTheme

@Composable
fun SplashScreen() {
    SplashContent()
}

@Composable
fun SplashContent() {
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("loading.json"))

    Scaffold(modifier = Modifier
        .fillMaxSize(),
        containerColor = MovieStreamingTheme.colorScheme.backgroundColor
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(vertical = 150.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
            )

            LottieAnimation(
                composition = composition,
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.BottomCenter),
                iterations = LottieConstants.IterateForever,
                maintainOriginalImageBounds = true
            )
        }
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SplashContent()
}