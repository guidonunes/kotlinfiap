package com.example.kotlinfiap.repository

import com.example.kotlinfiap.R
import com.example.kotlinfiap.model.Category
import com.example.kotlinfiap.model.DifficultyLevel
import com.example.kotlinfiap.model.Review
import com.example.kotlinfiap.model.User
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
        image = R.drawable.black_myth
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
        image = R.drawable.yotei
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
        image = R.drawable.baldurs_gate_3
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
        image = R.drawable.alan_wake_2
    ),
    Review(
        id = 5,
        category = Category(id = 7000, name = "Arcade"),
        user = User(id = 500, name = "Alex Casey"),
        difficultyLevel = DifficultyLevel.MEDIUM,
        name = "Hollow Knight",
        description = "A challenging, atmospheric 2D masterpiece set in a decaying insect kingdom.",
        campaignLength = 30,
        createdAt = LocalDate.now(),
        image = R.drawable.hollow_knight
    )
)

fun getReviewsByCategory(id: Int) = getAllReviews()
    .filter{ review ->
        review.category.id == id
    }


