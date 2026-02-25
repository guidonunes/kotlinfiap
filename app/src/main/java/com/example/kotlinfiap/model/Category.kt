package com.example.kotlinfiap.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.kotlinfiap.R

data class Category(
    val id: Int = 0,
    val name: String = "Name",
    @DrawableRes val image: Int? = R.drawable.no_image,
    val background: Color = Color.Gray
)
