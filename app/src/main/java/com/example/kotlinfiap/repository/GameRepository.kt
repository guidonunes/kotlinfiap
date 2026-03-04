package com.example.kotlinfiap.repository


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.kotlinfiap.R
import com.example.kotlinfiap.factory.RetrofitClient
import com.example.kotlinfiap.model.Category
import com.example.kotlinfiap.model.DifficultyLevel
import com.example.kotlinfiap.model.Review
import com.example.kotlinfiap.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate

fun getAllReviews() = listOf<Review>(
    Review(
        id = 1,
        category = Category(id = 1000, name = "Action"),
        user = User(id = 100, name = "John Doe"),
        difficultyLevel = DifficultyLevel.MEDIUM,
        name = "Black Myth: Wukong",
        description = "A brutal, mythic action RPG centered on the legendary Monkey King.",
        campaignLength = 40,
        createdAt = LocalDate.now(),
        image = "/images/elden_ring.jpg"
    ),
    Review(
        id = 2,
        category = Category(id = 2000, name = "Adventure"),
        user = User(id = 200, name = "Mary Doe"),
        difficultyLevel = DifficultyLevel.MEDIUM,
        name = "Ghost Of Yotei",
        description = "A cinematic samurai epic set in the rugged wilds of 17th-century Japan.",
        campaignLength = 50,
        createdAt = LocalDate.now(),
        image = "/images/hades.jpg"
    ),
    Review(
        id = 3,
        category = Category(id = 3000, name = "RPG"),
        user = User(id = 300, name = "Frodo Beggins"),
        difficultyLevel = DifficultyLevel.HARD,
        name = "Baldur's Gate 3",
        description = "A cinematic samurai epic set in the rugged wilds of 17th-century Japan.A sprawling, choice-heavy RPG masterfully adapting Dungeons & Dragons rules.",
        campaignLength = 120,
        createdAt = LocalDate.now(),
        image = "/images/bg3.jpg"
    ),
    Review(
        id = 4,
        category = Category(id = 1000, name = "Action"),
        user = User(id = 400, name = "Thomas Anderson"),
        difficultyLevel = DifficultyLevel.MEDIUM,
        name = "Alan Wake 2",
        description = "A surreal, dual-protagonist survival horror mystery blurring fiction and reality.",
        campaignLength = 25,
        createdAt = LocalDate.now(),
        image = "/images/forza_horizon_5.jpg"
    ),
)
@Composable
fun getReviewsByCategory(id: Int): List<Review> {
    var reviews by remember {
        mutableStateOf(listOf<Review>())
    }

    val callReviewsByCategory = RetrofitClient.getReviewService().getRecipesByCatergory(id)

    callReviewsByCategory.enqueue(object: Callback<List<Review>> {
        override fun onResponse(
            p0: Call<List<Review>?>?,
            response: Response<List<Review>?>?
        ) {
             reviews = response?.body() ?: emptyList()
        }

        override fun onFailure(
            p0: Call<List<Review>?>?,
            p1: Throwable?
        ) {
            println("Error: ${p1?.printStackTrace()}")
            println("Error: ${p1?.message}")
        }
    })

    return reviews
}

//fun getReviewsByCategory(id: Int) = getAllReviews()
//    .filter{ review ->
//        review.category.id == id
//    }


