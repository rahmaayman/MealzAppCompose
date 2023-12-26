package com.example.mealzappcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.mealzappcompose.presentation.meal_details_screen.mealDetailsRoute
import com.example.mealzappcompose.presentation.mealz.mealzRoute
import com.example.mealzappcompose.presentation.util.Screen

@Composable
fun MealzNavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.MealzScreen.route) {
        mealzRoute(navController = navController)
        mealDetailsRoute(navController = navController)
    }
}