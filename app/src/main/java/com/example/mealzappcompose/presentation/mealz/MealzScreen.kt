package com.example.mealzappcompose.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mealzappcompose.presentation.mealz.MealzViewModel

@Composable
fun MealzScreen(
    navController: NavController,
    viewModel: MealzViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Mealz(
                state = viewModel.state,
                navController = navController
            )
        }
        if (viewModel.state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
        viewModel.state.error?.let { error ->
            Text(
                text = error,
                color = Color.Red,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}