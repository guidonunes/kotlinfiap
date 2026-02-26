package com.example.kotlinfiap.repository

import androidx.compose.ui.graphics.Color
import com.example.kotlinfiap.R
import com.example.kotlinfiap.model.Category

fun getAllCategories() = listOf<Category>(
    Category(
        id = 1000,
        name = "Action",
        image = R.drawable.action,
        background = Color(0xffabf2e9)
    ),
    Category(
        id = 2000,
        name = "Adventure",
        image = R.drawable.adventure,
        background = Color(0xfff4d6c0)
    ),
    Category(
        id = 3000,
        name = "RPG",
        image = R.drawable.rpg,
        background = Color(0xffc6dafa)
    ),
    Category(
        id = 4000,
        name = "Simulation",
        image = R.drawable.simulation,
        background = Color(0xfff8d9d9)
    ),
    Category(
        id = 5000,
        name = "Racing",
        image = R.drawable.racing,
        background = Color(0xffabf2e8)
    ),
    Category(
        id = 6000,
        name = "Puzzle",
        image = R.drawable.puzzle,
        background = Color(0xff72412b)
    ),
    Category(
        id = 7000,
        name = "Arcade",
        image = R.drawable.arcade,
        background = Color(0xff80deea)
    )
)

fun getCategoryById(id: Int) = getAllCategories()
    .filter{ categoryType ->
        categoryType.id == id
    }