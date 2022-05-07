package com.telenav.oa.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.telenav.oa.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    @DrawableRes resId: Int = R.drawable.ic_splash_screen,
    onProgress: (SplashState) -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {
        Image(painter = painterResource(resId), contentDescription = "Splash Screen")
        LaunchedEffect(Unit) {
            for (second in 3 downTo 1) {
                onProgress(SplashState.Loading)
                delay(1000)
            }
            onProgress(SplashState.Done)
        }
    }
}

@Preview
@Composable
fun PreviewSplashScreen() {
    SplashScreen { }
}

sealed class SplashState {
    object Loading : SplashState()
    object Done : SplashState()
}