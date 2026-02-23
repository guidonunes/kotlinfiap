package com.example.kotlinfiap.navigation

sealed class Destination(val route: String) {
    object InitialScreen: Destination("initial")
    object SignUpScreen: Destination("signup")
    object HomeScreen: Destination("home")
    object LoginScreen: Destination("login")
}