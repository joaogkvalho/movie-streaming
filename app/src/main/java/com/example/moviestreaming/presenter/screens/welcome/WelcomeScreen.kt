package com.example.moviestreaming.presenter.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviestreaming.R
import com.example.moviestreaming.presenter.components.button.PrimaryButton
import com.example.moviestreaming.presenter.components.slide.WelcomeSlideUI
import com.example.moviestreaming.presenter.theme.MovieStreamingTheme

@Composable
fun WelcomeScreen() {
    WelcomeContent()
}

@Composable
fun WelcomeContent() {
    val slideItems = listOf(
        Pair(
            first = "Bem-vindo",
            second = "O melhor aplicativo de streaming de filmes do século para tornar seus dias incríveis"
        ),
        Pair(
            first = "Muitos Filmes",
            second = "Catálago com os melhores filmes e series da atualidade a sua disposição e a só um clique de distância"
        ),
        Pair(
            first = "Custo benefício",
            second = "Planos irresistíveis para todos, seja você sozinho ou toda a família, tudo isso com os melhores preços"
        )
    )
    val pagerState = rememberPagerState {
        slideItems.size
    }

    Scaffold(
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = paddingValues.calculateBottomPadding())
                    .background(MovieStreamingTheme.colorScheme.backgroundColor)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.placeholder_welcome),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )

                Image(
                    painter = painterResource(id = R.drawable.background_gradient),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    WelcomeSlideUI(
                        modifier = Modifier
                            .weight(1f),
                        slideItems = slideItems,
                        pagerState = pagerState
                    )

                    PrimaryButton(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(start = 24.dp, end = 24.dp, bottom = 32.dp),
                        text = "Pular",
                        isLoading = false,
                        enabled = true,
                        onClick = {}
                    )
                }
            }
        }
    )
}

@Preview
@Composable
private fun WelcomePreview() {
    WelcomeContent()
}