package com.example.mealzappcompose.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.domain.data.Category
import com.example.mealzappcompose.presentation.meal_details_screen.MealDetailsScreenContent
import com.example.mealzappcompose.presentation.meal_details_screen.MealDetailsViewModel

@Composable
fun MealDetailsScreen(
    navController: NavController,
    viewModel: MealDetailsViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val mealState = viewModel.state
    MealDetailsScreenContent(mealState = mealState)

}