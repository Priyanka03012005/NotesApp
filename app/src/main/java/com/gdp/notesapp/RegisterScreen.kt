package com.gdp.notesapp

import android.content.Intent
import android.os.Bundle
import android.telecom.Call
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.material.Icon
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition



lateinit var navController: NavController


@Composable
fun RegisterScreen(
    navController: NavController
) {
    var nameValue = remember { mutableStateOf("") }
    var emailValue = remember { mutableStateOf("") }
    var passwordValue = remember { mutableStateOf("") }
    var confirmPasswordValue = remember { mutableStateOf("") }
    val it = remember { mutableStateOf("String" ) }
    //
    var passwordVisibility by remember { mutableStateOf(false) }
    var confirmPasswordVisibility by remember { mutableStateOf(false) }

    Box(modifier = Modifier
        .fillMaxSize()
        .fillMaxHeight(),
        contentAlignment = Alignment.BottomCenter)
    {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            val compnotify by rememberLottieComposition(
                spec = LottieCompositionSpec.Asset("register.json"))
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
            modifier = Modifier
                //.fillMaxSize(0.7f)
                .fillMaxWidth()
                .fillMaxHeight(0.75f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Text(
                    text = "Sign Up",
                    fontSize = 20.sp,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        letterSpacing =  2.sp,
                    )
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Column(modifier = Modifier
                    .fillMaxSize()
                    .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = nameValue.value,
                        onValueChange = {
                            nameValue.value = it
                        },
                        label = {
                            Text(
                                text = "Name"
                            )
                        },
                        placeholder = { Text(text = "Name") },
                        singleLine =  true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )
                    OutlinedTextField(
                        value = emailValue.value,
                        onValueChange = {
                            emailValue.value = it
                        },
                        label={ Text( text = "Email Address") },
                        placeholder = { Text(text = " Email Address")},
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )
                    OutlinedTextField(
                        value = passwordValue.value,
                        onValueChange = {
                            passwordValue.value = it
                        },
                        label = { Text(text = "Password")},
                        placeholder = { Text (text = "Password")},
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibility = !passwordVisibility
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.visibility),
                                    contentDescription = "visible",
                                    tint = if(passwordVisibility) Color.Black else Color.Gray
                                )
                            }
                        },
                        visualTransformation = if ( passwordVisibility) VisualTransformation.None
                        else PasswordVisualTransformation()
                    )
                    OutlinedTextField(
                        value = confirmPasswordValue.value,
                        onValueChange = { confirmPasswordValue.value = it },
                        label = {
                            Text(text = "Confirm Password")
                        },
                        placeholder = {
                            Text(text = "Confirm Password")
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        trailingIcon = {
                            IconButton(onClick = {
                                confirmPasswordVisibility = !confirmPasswordVisibility
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.visibility),
                                    contentDescription = "visible",
                                    tint = if (confirmPasswordVisibility) Color.Black else Color.Gray
                                )
                            }
                        },
                        visualTransformation = if ( confirmPasswordVisibility) VisualTransformation.None
                        else PasswordVisualTransformation()
                    )

                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(onClick = { }, modifier = Modifier
                        .fillMaxWidth(0.8f)
                    ) {
                        Text(text = "Sign Up", fontSize = 20.sp,
                          modifier = Modifier.clickable {
                          }
                            )
                    }
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(text = "Login Instead",
                        modifier = Modifier.clickable {
                            navController.navigate( route = com.gdp.notesapp.Screen.Login.route)
                        }
                    )
                    Spacer(modifier = Modifier.padding(20.dp))
                }

            }
        }
    }
}




