package com.example.moviestreaming.presenter.components.slide

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviestreaming.R
import com.example.moviestreaming.presenter.components.indicator.SlideIndicator
import com.example.moviestreaming.presenter.theme.MovieStreamingTheme
import com.example.moviestreaming.presenter.theme.UrbanistFamily

@Composable
fun WelcomeSlideUI(
    modifier: Modifier = Modifier,
    slideItems: List<Pair<String, String>>,
    pagerState: PagerState
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            pageContent = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = slideItems[pagerState.currentPage].first,
                        style = TextStyle(
                            fontSize = 40.sp,
                            lineHeight = 48.sp,
                            fontFamily = UrbanistFamily,
                            fontWeight = FontWeight.Bold,
                            color = MovieStreamingTheme.colorScheme.whiteColor,
                            textAlign = TextAlign.Center
                        )
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = slideItems[pagerState.currentPage].second,
                        style = TextStyle(
                            fontSize = 18.sp,
                            lineHeight = 25.2.sp,
                            fontFamily = UrbanistFamily,
                            fontWeight = FontWeight.Medium,
                            color = MovieStreamingTheme.colorScheme.whiteColor,
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.2.sp
                        )
                    )
                }
            }
        )

        SlideIndicator(
            modifier = Modifier
                .padding(bottom = 32.dp),
            totalIndicators = slideItems.size,
            currentIndicator = pagerState.currentPage
        )
    }
}

@Preview
@Composable
private fun WelcomePreview() {
    val slideItems = listOf(
        Pair(
            first = "Bem-vindo",
            second = "O melhor aplicativo de streaming de filmes do século para tornar seus dias incríveis"
        ),
        Pair(
            first = "Bem-vindo",
            second = "O melhor aplicativo de streaming de filmes do século para tornar seus dias incríveis"
        ),
        Pair(
            first = "Bem-vindo",
            second = "O melhor aplicativo de streaming de filmes do século para tornar seus dias incríveis"
        )
    )
    val pagerState = rememberPagerState {
        slideItems.size
    }

    WelcomeSlideUI(
        slideItems = slideItems,
        pagerState = pagerState
    )
}