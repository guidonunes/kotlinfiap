package com.example.kotlinfiap.model

import androidx.annotation.DrawableRes
import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class Review(
    val id: Int = 0,
    val category: Category,
    val user: User,
    val difficultyLevel: DifficultyLevel,
    @SerializedName("title") val name: String = "",
    val description: String="",
    @SerializedName("cookingTime") val campaignLength: Int=0,
    val createdAt: LocalDate = LocalDate.now(),
    @SerializedName("url") val image: String = ""
)
