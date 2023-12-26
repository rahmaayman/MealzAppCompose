package com.example.data.remote

import com.example.domain.data.CategoryResponse
import retrofit2.http.GET

interface ApiService {

    @GET("categories.php")
    suspend fun getMealz(): CategoryResponse
}