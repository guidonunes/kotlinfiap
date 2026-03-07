package com.example.kotlinfiap.service

import com.example.kotlinfiap.model.Category
import com.example.kotlinfiap.model.ConsoleUsed
import com.example.kotlinfiap.model.Curiosity
import com.example.kotlinfiap.model.Review
import com.example.kotlinfiap.model.ReviewRequest
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface ReviewService {
    @GET("reviews/categories/{categoryId}")
    fun getReviewsByCategory(@Path("categoryId")id: Int): Call<List<Review>>

    @GET("reviews/recents")
    fun getLatestReviews(): Call<List<Review>>

    @POST("reviews")
    suspend fun saveReview(@Body reviewRequest: ReviewRequest): ReviewRequest

    @POST("reviews/{reviewId}/ingredients")
    suspend fun saveReviewCuriosities(
            @Path("reviewId") reviewId: Int,
            @Body curiosities: List<Curiosity>
    ): List<Curiosity>

    @POST("reviews/{reviewId}/preparation-methods")
    suspend fun saveReviewConsoleUsed(
        @Path("reviewId") reviewId: Int,
        @Body consoleUsed: List<ConsoleUsed>
    ): List<ConsoleUsed>

    @Multipart
    @POST("reviews/{reviewId}/upload-image")
    suspend fun uploadImage(
        @Path("reviewId") reviewId: Int,
        @Part file: MultipartBody.Part
    ): Review

}
