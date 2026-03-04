package com.example.kotlinfiap.repository

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.example.kotlinfiap.R
import com.example.kotlinfiap.factory.RetrofitClient
import com.example.kotlinfiap.model.Category
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun getAllCategories(): List<Category> {
    var categories by remember {
        mutableStateOf(listOf<Category>())

    }
    val callCategories = RetrofitClient.getCategoryService().getAllCategories()

    callCategories.enqueue(object: Callback<List<Category>>{
        override fun onResponse(
            call: Call<List<Category>?>?,
            response: Response<List<Category>?>?
        ) {
            categories = response?.body()!!
        }

        override fun onFailure(
            p0: Call<List<Category>?>?,
            p1: Throwable?
        ) {
            println("Error: ${p1?.printStackTrace()}")
        }

    })
    return categories
}

//fun getAllCategories() = listOf<Category>(
//    Category(
//        id = 1000,
//        name = "Action",
//        image = R.drawable.action,
//        background = Color(0xffabf2e9)
//    ),
//    Category(
//        id = 2000,
//        name = "Adventure",
//        image = R.drawable.adventure,
//        background = Color(0xfff4d6c0)
//    ),
//    Category(
//        id = 3000,
//        name = "RPG",
//        image = R.drawable.rpg,
//        background = Color(0xffc6dafa)
//    ),
//    Category(
//        id = 4000,
//        name = "Simulation",
//        image = R.drawable.simulation,
//        background = Color(0xfff8d9d9)
//    ),
//    Category(
//        id = 5000,
//        name = "Racing",
//        image = R.drawable.racing,
//        background = Color(0xffabf2e8)
//    ),
//    Category(
//        id = 6000,
//        name = "Puzzle",
//        image = R.drawable.puzzle,
//        background = Color(0xff72412b)
//    ),
//    Category(
//        id = 7000,
//        name = "Arcade",
//        image = R.drawable.arcade,
//        background = Color(0xff80deea)
//    )
//)

//fun getCategoryById(id: Int) = getAllCategories()
//    .firstOrNull { it.id == id }