package com.example.domain.repo

import com.example.domain.data.CategoryResponse
import com.example.mealzappcompose.domain.util.Resource

interface MealzRepo {
    suspend fun getMealzFromRemote(): Resource<CategoryResponse>
}