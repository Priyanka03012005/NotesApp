package com.gdp.notesapp

import android.accessibilityservice.AccessibilityService
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController: NavHostController
){

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
        ){
        composable(
            route = Screen.Splash.route
        ){
            AnimatedSplashScreen(navController=navController)
        }
         composable(
             route = Screen.Register.route
         ){
             RegisterScreen(navController = navController)
         }
        composable(
            route = Screen.Login.route
        ){
            LoginScreen(navController = navController)
        }
    }
}