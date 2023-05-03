package com.gdp.notesapp

sealed class Screen (val route:String){
    object Register : Screen(route = "register_screen")
    object Login : Screen(route = "login_screen")
    object Splash : Screen(route = "animated_splash_screen")


}
