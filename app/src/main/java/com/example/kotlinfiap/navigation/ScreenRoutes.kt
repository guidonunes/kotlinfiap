package com.example.kotlinfiap.navigation

sealed class Destination(val route: String) {
    object InitialScreen: Destination("initial")
    object SignUpScreen: Destination("signup")
    object HomeScreen: Destination("home/{email}") {
        fun createRoute(email: String): String {
            return "home/$email"
        }
    }
    object LoginScreen: Destination("login")

    object ReviewCategoryScreen: Destination("review_category/{categoryId}") {
        fun createRoute(categoryId: Int): String {
            return "review_category/$categoryId"
        }
    }
}