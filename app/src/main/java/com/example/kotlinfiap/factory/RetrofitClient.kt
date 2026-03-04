package com.example.kotlinfiap.factory

import com.example.kotlinfiap.service.CategoryService
import com.example.kotlinfiap.service.ReviewService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    const val BASE_URL = "http://10.0.2.2:8080/api/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getCategoryService(): CategoryService {
        return retrofit.create(CategoryService::class.java)
    }

    fun getReviewService(): ReviewService {
        return retrofit.create(ReviewService::class.java)
    }
}