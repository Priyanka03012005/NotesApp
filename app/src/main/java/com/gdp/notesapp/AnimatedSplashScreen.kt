package com.gdp.notesapp

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplashScreen(
    navController: NavController
){
    var startAnimattion by remember {
        mutableStateOf(false)
    }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimattion) 1f else 0f,
    animationSpec = tween(
        durationMillis = 3000
    ))
    LaunchedEffect(
        key1 = true ,){
        startAnimattion = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(Screen.Register.route)
    }
    Splash(alpha = alphaAnim.value)
}
@Composable
fun Splash(alpha: Float){
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        val compnotify by rememberLottieComposition(
            spec = LottieCompositionSpec.Asset("welcome.json"))
        val progress by animateLottieCompositionAsState(compnotify)
        LottieAnimation(
            composition = compnotify,
            iterations = 100,
            // isPlaying = play,
            contentScale = ContentScale.Crop,
            speed = 0.6f,
            modifier = Modifier
                .size(200.dp)
                .alpha(alpha = alpha)
                .padding(end = 10.dp, top = 0.dp, start = 10.dp)
        )


    }
}