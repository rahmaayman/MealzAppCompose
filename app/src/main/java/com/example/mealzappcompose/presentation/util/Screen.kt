package com.example.mealzappcompose.presentation.util

sealed class Screen(val route: String) {
    object MealzScreen: Screen("MealzScreen")
    object MealDetailsScreen: Screen("MealDetailsScreen")
}
