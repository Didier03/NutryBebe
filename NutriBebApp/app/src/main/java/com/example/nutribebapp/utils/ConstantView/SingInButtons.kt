package com.example.nutribebapp.utils.ConstantView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nutribebapp.R
import com.example.nutribebapp.ui.theme.black
import com.example.nutribebapp.ui.theme.bulegoogle
import com.example.nutribebapp.ui.theme.grayLigth
import com.example.nutribebapp.ui.theme.white
import com.example.nutribebapp.ui.theme.yellowBintage


@Composable
fun SignInButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = yellowBintage,
            contentColor = black
        ),
        shape = RoundedCornerShape(4.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Iniciar sesión")
        }
    }
}
@Preview
@Composable
fun GoogleSignInButton(modifier: Modifier = Modifier) {
    Button(
        modifier = modifier,
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = grayLigth,
            contentColor = white
        ),
        shape = RoundedCornerShape(4.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.cromo),
                contentDescription = "Google Icon",
                tint = Color.Unspecified
            )
        }
    }
}
@Composable
fun FacebookSingInButton(modifier: Modifier = Modifier) {
    Button(
        modifier = modifier,
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = grayLigth,
            contentColor = white
        ),
        shape = RoundedCornerShape(4.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = "Google Icon",
                tint = Color.Unspecified
            )
        }
    }
}
@Composable
fun EmailSingInButton(modifier: Modifier = Modifier) {
    Button(
        modifier = modifier,
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = grayLigth,
            contentColor = white
        ),
        shape = RoundedCornerShape(4.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.correo),
                contentDescription = "Google Icon",
                tint = Color.Unspecified
            )
        }
    }
}