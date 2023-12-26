package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.data.CategoryResponse
import com.example.domain.repo.MealzRepo
import com.example.mealzappcompose.domain.util.Resource

class MealzRepoImp(private val apiService: ApiService) : MealzRepo {
    override suspend fun getMealzFromRemote(): Resource<CategoryResponse> =
        try {
            Resource.Success(
                data = apiService.getMealz()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
}