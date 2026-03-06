package com.example.kotlinfiap.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.example.kotlinfiap.screens.AddReviewCuriositiesScreen
import com.example.kotlinfiap.screens.AddReviewScreen
import com.example.kotlinfiap.screens.HomeScreen
import com.example.kotlinfiap.screens.InitialScreen
import com.example.kotlinfiap.screens.LoginScreen
import com.example.kotlinfiap.screens.SignUpScreen
import com.example.kotlinfiap.screens.ProfileScreen
import com.example.kotlinfiap.screens.ReviewCategoryScreen

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
        composable(
            route = Destination.HomeScreen.route,
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "https://kotlinfiap.example.com/email/{email}"
                    action = Intent.ACTION_VIEW
                }
            ),
            arguments = listOf(navArgument("email") {
                type = NavType.StringType
            })

        ) {backStackEntry ->
            var email = backStackEntry.arguments?.getString("email")
            HomeScreen(navController, email)
        }
        composable(Destination.SignUpScreen.route) {
            SignUpScreen(navController)
        }

        composable(Destination.ProfileScreen.route,
            arguments = listOf(
                navArgument("email") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val email = backStackEntry.arguments?.getString("email")
            ProfileScreen(navController, email)
        }


        composable(Destination.LoginScreen.route) {
            LoginScreen(navController)
        }

        composable(
            route = Destination.ReviewCategoryScreen.route,
            arguments = listOf(
                navArgument(name = "categoryId") {
                    type = NavType.IntType
                }
            )
        ) {
            val categoryId = it.arguments?.getInt("categoryId")
            ReviewCategoryScreen(categoryId, navController)
        }

        composable(Destination.AddReviewScreen.route) {
            AddReviewScreen(navController)
        }

        composable(
            route = Destination.AddReviewCuriositiesScreen.route,
            arguments = listOf(
                navArgument(
                    name = "reviewId"
                ) { type = NavType.IntType },
                navArgument(
                    name = "reviewTitle"
                ) { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val reviewId = backStackEntry.arguments?.getInt("reviewId")
            val reviewTitle = backStackEntry.arguments?.getString("reviewTitle")
            AddReviewCuriositiesScreen(
                navController,
                reviewId,
                reviewTitle
            )
        }
    }
}

