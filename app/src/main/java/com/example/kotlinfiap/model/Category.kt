package com.example.kotlinfiap.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.kotlinfiap.R
import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("categoryId") val id: Int = 0,
    @SerializedName("categoryName") val name: String = "Name",
    @SerializedName("url") val image: String = "",
    @SerializedName("color")val background: String = "FFFFFF",
)
