package com.example.nutribebapp.presentation.view.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.nutribebapp.R
import com.example.nutribebapp.ui.theme.backgraunPurple
import com.example.nutribebapp.ui.theme.backgraundGren
import com.example.nutribebapp.ui.theme.backgraundPrincipal
import com.example.nutribebapp.ui.theme.white
import com.example.nutribebapp.utils.ConstantView.EmailSingInButton
import com.example.nutribebapp.utils.ConstantView.FacebookSingInButton
import com.example.nutribebapp.utils.ConstantView.GoogleSignInButton
import com.example.nutribebapp.utils.ConstantView.PasswordTextField
import com.example.nutribebapp.utils.ConstantView.SignInButton
import com.example.nutribebapp.utils.ConstantView.UsernameTextField
import com.example.nutribebapp.utils.SingleColorBackground

class LoginView : Screen {
    @Preview
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        var showSignInOptions by remember { mutableStateOf(false) }
        val configuration = LocalConfiguration.current
        val screenHeight = configuration.screenHeightDp.dp

        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures { offset ->
                        if (showSignInOptions) {
                            showSignInOptions = false
                        }
                    }
                },
            contentAlignment = Alignment.BottomCenter) {
            SingleColorBackground(backgroundColor = backgraundGren)

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(35.dp)
                    .align(Alignment.Center)
                    .animateContentSize(animationSpec = tween(durationMillis = 300)), // Animación suave
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.nino),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(if (showSignInOptions) 150.dp else 300.dp) // Tamaño más pequeño cuando se muestran las opciones
                        .padding(bottom = if (showSignInOptions) 20.dp else 50.dp),
                    contentScale = ContentScale.Fit
                )
                Text(
                    modifier = Modifier.padding(bottom = if (showSignInOptions) 10.dp else 20.dp),
                    text = "NutriBebe",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontSize = if (showSignInOptions) 24.sp else 32.sp
                    ),
                    textAlign = TextAlign.Center
                )
                Text(
                    modifier = Modifier.padding(bottom = if (showSignInOptions) 10.dp else 20.dp),
                    text = "El seguimiento de tu bebe sera mas facil ahora",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = if (showSignInOptions) 14.sp else 16.sp
                    ),
                    textAlign = TextAlign.Center
                )
                if (showSignInOptions){
                    Spacer(modifier = Modifier.weight(1f))
                }else{
                    Spacer(modifier = Modifier)
                }
                SignInButton(onClick = { showSignInOptions = true }, modifier = Modifier.fillMaxWidth())

            }

            AnimatedVisibility(
                visible = showSignInOptions,
                enter = slideInVertically(initialOffsetY = { it }),
                exit = slideOutVertically(targetOffsetY = { it }),
                modifier = Modifier.align(Alignment.BottomCenter) // Alinea la Card en la parte inferior
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth() // Ocupa todo el ancho del Box
                        .heightIn(max = screenHeight * 0.6f), // Ocupa hasta el 60% de la altura de la pantalla (ajusta según necesites)
                    shape = RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp), // Bordes redondeados solo en la parte superior
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .background(Color.White)
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(text = "Iniciar seción")
                        UsernameTextField(
                            value = username,
                            onValueChange = { username = it },
                            modifier = Modifier.padding(bottom = 30.dp)
                        )
                        PasswordTextField(
                            value = password,
                            onValueChange = { password = it },
                            modifier = Modifier.padding(bottom = 30.dp)
                        )
                        SignInButton(onClick = { /* TODO: Handle sign in */ }, modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp))
                        Text(text = "O Registrate")
                        Row {
                            GoogleSignInButton(modifier = Modifier
                                .padding(end = 10.dp)
                                .height(50.dp))
                            FacebookSingInButton(modifier = Modifier
                                    .padding(end = 10.dp)
                                    .height(50.dp)
                            )
                            EmailSingInButton(modifier = Modifier
                                .padding(end = 10.dp)
                                .height(50.dp))
                        }
                        Spacer(modifier = Modifier.height(16.dp)) // Espacio antes del botón "Iniciar Sesión"
                    }
                }
            }
        }
    }
}