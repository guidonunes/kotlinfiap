package com.example.kotlinfiap.model

data class ReviewRequest(
    val id: Int? = null,
    val title: String = "",
    val difficultyLevel: DifficultyLevel = DifficultyLevel.EASY,
    val description: String = "",
    val cookingTime: Int = 0,
    val creationDate: String = "",
    val category: Category = Category(id = 1),
)
