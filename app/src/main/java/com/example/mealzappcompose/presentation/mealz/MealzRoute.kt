package com.example.mealzappcompose.presentation.mealz

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mealzappcompose.presentation.MealzScreen
import com.example.mealzappcompose.presentation.util.Screen

fun NavGraphBuilder.mealzRoute(
    navController: NavController
) {
    composable(route = Screen.MealzScreen.route){
        MealzScreen(navController = navController)
    }

}