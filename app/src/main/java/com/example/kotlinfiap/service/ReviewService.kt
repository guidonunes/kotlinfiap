package com.example.kotlinfiap.service

import com.example.kotlinfiap.model.Category
import com.example.kotlinfiap.model.Review
import com.example.kotlinfiap.model.ReviewRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ReviewService {
    //http://localhost:8080/api/reviews/categories/5
    @GET("reviews/categories/{categoryId}")
    fun getRecipesByCatergory(@Path("categoryId")id: Int): Call<List<Review>>

    @GET("reviews/recents")
    fun getLatestRecipes(): Call<List<Review>>

    @POST("reviews")
    suspend fun saveReview(@Body reviewRequest: ReviewRequest): ReviewRequest

    @POST("reviews/{reviewId}/curiosities")
    suspend fun saveReviewCuriosities(
            @Path("reviewId") reviewId: Int,
            @Body curiosities: List<Category>
    ): List<Category>
}


