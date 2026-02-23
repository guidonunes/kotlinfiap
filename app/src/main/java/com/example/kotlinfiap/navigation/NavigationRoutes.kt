package com.example.kotlinfiap.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlinfiap.screens.InitialScreen

@Composable
fun NavigationRoutes() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destination.InitialScreen.route
    ) {
        composable(Destination.InitialScreen.route){
            InitialScreen()
        }
    }
}