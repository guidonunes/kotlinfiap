package com.example.kotlinfiap.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlinfiap.screens.HomeScreen
import com.example.kotlinfiap.screens.InitialScreen
import com.example.kotlinfiap.screens.LoginScreen
import com.example.kotlinfiap.screens.SignUpScreen

@Composable
fun NavigationRoutes() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destination.InitialScreen.route
    ) {
        composable(Destination.InitialScreen.route){
            InitialScreen(navController)
        }
        composable(Destination.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(Destination.SignUpScreen.route) {
            SignUpScreen(navController)
        }
        composable(Destination.LoginScreen.route) {
            LoginScreen(navController)
        }
    }
}