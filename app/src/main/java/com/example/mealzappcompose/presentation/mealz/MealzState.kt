package com.example.mealzappcompose.presentation.mealz

import com.example.domain.data.CategoryResponse

data class MealzState(
    val categoryResponse: CategoryResponse? = null,
    val isLoading: Boolean = false,
    val error: String? = null

)