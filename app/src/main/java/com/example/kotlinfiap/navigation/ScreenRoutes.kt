package com.example.kotlinfiap.navigation

sealed class Destination(val route: String) {
    object InitialScreen: Destination("initial")
    object SignUpScreen: Destination("signup")

    object AddReviewScreen: Destination("addReviewScreen")
    object ProfileScreen: Destination("profile/{email}") {
        fun createRoute(email: String): String {
            return "profile/$email"
        }
    }
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

    object AddReviewCuriositiesScreen: Destination(
        route = "addCuriosities/{reviewId}/{reviewTitle}"
    ) {
        fun createRoute(
            reviewId: Int,
            reviewTitle: String
        ): String {
            return "addCuriosities/$reviewId/$reviewTitle"
        }
    }

    object AddReviewConsoleUsedScreen: Destination(
        route = "addConsoleUsed/{reviewId}/{reviewTitle}"
    ) {
        fun createRoute(
            reviewId: Int,
            reviewTitle: String
        ): String {
            return "addConsoleUsed/$reviewId/$reviewTitle"
        }
    }

    object AddReviewPhotoScreen : Destination("addPhoto/{reviewId}") {
        fun createRoute(reviewId: Int): String {
            return "addPhoto/$reviewId"
        }
    }
}