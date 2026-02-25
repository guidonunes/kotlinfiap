package com.example.kotlinfiap.model

import androidx.annotation.DrawableRes
import java.time.LocalDate

data class Review(
    val id: Int = 0,
    val category: Category,
    val user: User,
    val difficultyLevel: DifficultyLevel,
    val name: String = "",
    val description: String="",
    val campaignLength: Int=0,
    val createdAt: LocalDate = LocalDate.now(),
    @DrawableRes val image: Int
)
