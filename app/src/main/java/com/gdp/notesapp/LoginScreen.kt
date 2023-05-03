package com.gdp.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun LoginScreen(navController: NavController) {
    val emailAddress = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }


    var passwordVisibility by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
         contentAlignment = Alignment.Center
    )
    {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            val compnotify by rememberLottieComposition(
                spec = LottieCompositionSpec.Asset("login1.json"))
            val progress by animateLottieCompositionAsState(compnotify)
            LottieAnimation(
                composition = compnotify,
                iterations = 1,
                // isPlaying = play,
                contentScale = ContentScale.Crop,
                //  speed = f,
                modifier = Modifier
                    .size(200.dp)
                    .padding(end = 10.dp, top = 0.dp, start = 10.dp)
            )


        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Sign In",
                    fontSize = 20.sp,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        letterSpacing =  2.sp,
                    )
                )
                OutlinedTextField(
                    value = emailAddress.value,
                    onValueChange = {
                        emailAddress.value = it
                    },
                    label = {
                        Text(text = "Email Address")
                    },
                    modifier = Modifier.fillMaxWidth(0.8f)
                )
                OutlinedTextField(value = passwordValue.value,
                    onValueChange = {
                        passwordValue.value = it
                    },
                    label = { Text(text = "Password") },
                    placeholder = { Text(text = "Password") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f),
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisibility = !passwordVisibility
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.visibility),
                                contentDescription = "",
                                tint = if (passwordVisibility) Color.Gray else Color.Black
                            )
                        }
                    },
                    visualTransformation = if ( passwordVisibility) VisualTransformation.None
                    else PasswordVisualTransformation()
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Button(onClick = { }, modifier = Modifier
                    .fillMaxWidth(0.8f)
                ) {
                    Text(text = "Sign In", fontSize = 20.sp,

                        )
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = "Register Instead",
                    modifier = Modifier.clickable {
                        navController.navigate( route = com.gdp.notesapp.Screen.Register.route)
                    }
                )
                Spacer(modifier = Modifier.padding(20.dp))

            }
        }
    }
}


fun login(email:String, password:String) {

}
