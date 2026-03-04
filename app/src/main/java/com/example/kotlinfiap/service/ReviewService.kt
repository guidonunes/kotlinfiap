package com.example.kotlinfiap.service

import com.example.kotlinfiap.model.Review
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ReviewService {
    //http://localhost:8080/api/reviews/categories/5
    @GET("reviews/categories/{categoryId}")
    fun getRecipesByCatergory(@Path("categoryId")id: Int): Call<List<Review>>
}