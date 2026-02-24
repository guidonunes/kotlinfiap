package com.example.kotlinfiap.model

import androidx.annotation.DrawableRes

data class Category(
    val id: Int = 0,
    val name: String = "",
    @DrawableRes val image: Int? = 0
)
