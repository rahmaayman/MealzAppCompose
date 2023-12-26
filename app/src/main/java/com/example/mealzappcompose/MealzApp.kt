package com.example.mealzappcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mealzappcompose.presentation.MealDetailsScreen
import com.example.mealzappcompose.presentation.MealzScreen
import com.example.mealzappcompose.presentation.ui.theme.MealzAppComposeTheme
import com.example.mealzappcompose.presentation.util.Screen

@Composable
fun MealzApp() {
    MealzAppComposeTheme {
        val navController = rememberNavController()
        MealzNavGraph(navController = navController)

    }
}