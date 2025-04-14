package com.example.nutribebapp.presentation.view.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.nutribebapp.R
import com.example.nutribebapp.presentation.view.login.LoginView
import com.example.nutribebapp.ui.theme.backgraundColor
import com.example.nutribebapp.ui.theme.backgraundGren
import com.example.nutribebapp.utils.VerticalGradientBackgraund
import kotlinx.coroutines.delay

class SplashView(): Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        var scale by remember { mutableStateOf(0.5f) }
        val animatedScale by animateFloatAsState(
            targetValue = scale,
            animationSpec = androidx.compose.animation.core.tween(durationMillis = 1000)
        )
        LaunchedEffect(Unit){
            scale = 2f
            delay(1500)
            navigator.replace(LoginView())
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            VerticalGradientBackgraund(
                topColor = backgraundColor,
                bottomColor = backgraundGren,
            )
            Image(
                painter = painterResource(R.drawable.bebita),
                contentDescription = "logo",
                modifier = Modifier
                    .size(150.dp)
                    .scale(animatedScale),
                contentScale = ContentScale.Fit
            )
        }
    }
}
